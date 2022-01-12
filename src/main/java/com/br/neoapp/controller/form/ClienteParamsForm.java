package com.br.neoapp.controller.form;

import com.br.neoapp.validation.Celular;
import com.br.neoapp.validation.Cpf;
import com.br.neoapp.validation.DataDeNascimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Validated
public class ClienteParamsForm {

    private String nome;
    private String celular;
    private String email;
    private String cpf;
    private LocalDate dataDeNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "{notBlank.nome}") @Length(min = 5, max = 40, message = "{invalid.nome}") String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(@NotBlank(message = "{notBlank.celular}") @Celular(message = "{invalid.celular}") String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "{notBlank.email}") @Email(message = "{invalid.email}") String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "{notBlank.cpf}") @Cpf(message = "{invalid.cpf}") String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public void setDataDeNascimento(@NotNull(message = "{notNull.dataDeNascimento}") @DataDeNascimento(message = "{invalid.dataDeNascimento}") LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
