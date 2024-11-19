package br.com.syonet.model;

import java.net.URL;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Noticia extends PanacheEntity {

    @NotNull(message = "Título não pode ser nulo")
    private String titulo;

    @NotNull(message = "Descrição não pode ser nula")
    private String descricao;

    private URL url;

    
    public Noticia(){
        }

    public Noticia(String titulo, String descricao, URL url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Noticia [titulo=" + titulo + ", descricao=" + descricao + ", url=" + url + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Column(nullable = false)
    public boolean processada = false;

}
