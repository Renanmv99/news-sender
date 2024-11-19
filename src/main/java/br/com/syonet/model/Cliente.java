package br.com.syonet.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cliente extends PanacheEntity {

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "E-mail não pode ser nulo")
    @Email(message = "O e-mail deve ser válido")
    public String email;

    private LocalDate nascimento;

    public Cliente(){
        }

    public Cliente(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", email=" + email + ", nascimento=" + nascimento + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
