package br.com.syonet.service;

import br.com.syonet.model.Noticia;
import br.com.syonet.model.Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmailService {

    private final Mailer mailer;

    @Inject
    public EmailService(Mailer mailer) {
        this.mailer = mailer;
    }

    @Transactional
    public void enviarNoticiasNaoProcessadas() {
    List<Cliente> clientes = Cliente.listAll();

    if (clientes.isEmpty()) {
        System.out.println("Nenhum cliente encontrado. E-mail não enviado.");
        return;
    }

    List<Noticia> noticiasNaoProcessadas = Noticia.find("processada", false).list();

    if (noticiasNaoProcessadas.isEmpty()) {
        System.out.println("Nenhuma notícia não processada encontrada.");
        return;
    }

    String htmlTemplate = loadHtmlTemplate();

        StringBuilder htmlContent = new StringBuilder();

        for (Noticia noticia : noticiasNaoProcessadas) {
            
        htmlContent.append("<li>");

        if (noticia.getUrl() != null && !noticia.getUrl().toString().isEmpty()) {
            htmlContent.append("<strong><a href='").append(noticia.getUrl()).append("'>")
                .append(noticia.getTitulo())
                .append("</a></strong>: ");
        } else {
            htmlContent.append("<strong>").append(noticia.getTitulo()).append("</strong>: ");
        }

    htmlContent.append(noticia.getDescricao())
        .append("</li>")
        .append("<hr style='border: none; border-top: 1px solid #ddd; margin: 20px 0;'>");

            noticia.processada = true;
            noticia.persist();
        }

        String finalHtmlContent = htmlTemplate.replace("{{noticias}}", htmlContent.toString());

        for (Cliente cliente : clientes) {

        String personalizedContent = finalHtmlContent.replace("{{nome_cliente}}", cliente.getNome());

        if (cliente.getNascimento() != null &&
            cliente.getNascimento().getMonth() == LocalDate.now().getMonth() &&
            cliente.getNascimento().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {

            personalizedContent = personalizedContent.replace("{{aniversario}}", "Feliz aniversário!");
        } else {
            personalizedContent = personalizedContent.replace("{{aniversario}}", "");
        }

        this.mailer.send(Mail.withHtml(cliente.getEmail(), "Notícias do dia!", personalizedContent));
        System.out.println("Notícias enviadas!");
    }
}

    private String loadHtmlTemplate() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("templates/index.html");
            if (is == null) {
                throw new IOException("Template não encontrado.");
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
            }
        }

        @Scheduled(cron = "0 0 8 * * ?")
            public void agendarEnvioDiario() {
            enviarNoticiasNaoProcessadas();
        }
}