package com.br.neoapp.controller.dto;

import com.br.neoapp.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ClienteDto {

    private Long id;
    private String nome;
    private String celular;
    private String email;
    private String cpf;
    private LocalDate dataDeNascimento;
    private LocalDateTime dataDeCriacao;
    private LocalDateTime dataDeAtualizacao;
    private int idade;

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.celular = cliente.getCelular();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.dataDeNascimento = cliente.getDataDeNascimento();
        this.dataDeCriacao = cliente.getDataDeCriacao();
        this.dataDeAtualizacao = cliente.getDataDeAtualizacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDateTime getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public Integer getIdade() {
        if(dataDeNascimento != null)
            return Period.between(dataDeNascimento, LocalDate.now()).getYears();
        return null;
    }
}
