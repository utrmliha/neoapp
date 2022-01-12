package com.br.neoapp.controller.form;

import com.br.neoapp.model.Cliente;
import com.br.neoapp.validation.Celular;
import com.br.neoapp.validation.Cpf;
import com.br.neoapp.validation.DataDeNascimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteForm {

    @NotBlank(message = "{notBlank.nome}")
    @Length(min = 5, max = 40, message = "{invalid.nome}")
    private String nome;

    @NotBlank(message = "{notBlank.celular}")
    @Celular(message = "{invalid.celular}")
    private String celular;

    @NotBlank(message = "{notBlank.email}")
    @Email(message = "{invalid.email}")
    private String email;

    @NotBlank(message = "{notBlank.cpf}")
    @Cpf(message = "{invalid.cpf}")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{notNull.dataDeNascimento}")
    @DataDeNascimento(message = "{invalid.dataDeNascimento}")
    private LocalDate dataDeNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Cliente toCliente(){
        return new Cliente(null, this.nome, this.celular, this.email, this.cpf, this.dataDeNascimento, null, null);
    }
}
