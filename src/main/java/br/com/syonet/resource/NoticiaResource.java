package br.com.syonet.resource;

import java.util.List;

import br.com.syonet.model.Noticia;
import br.com.syonet.service.EmailService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/noticias")
public class NoticiaResource {

    private EmailService emailService;

    @Inject
    NoticiaResource(EmailService emailService){
        this.emailService = emailService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Noticia> listarNoticias() {
        return Noticia.findAll().list();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create (@Valid Noticia noticia){
        noticia.persist();
        return Response.status(Response.Status.CREATED).entity(noticia).build();
    }

    //curl -X POST http://localhost:8080/noticias/enviar-noticias
    @POST
    @Path("/enviar-noticias")
    public Response enviarNoticias() {
        emailService.enviarNoticiasNaoProcessadas();
        return Response.status(Response.Status.OK)
        .entity("Notícias enviadas com sucesso!")
        .build();
    }
}
