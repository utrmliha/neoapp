package com.br.neoapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String celular;
    private String email;
    private String cpf;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    private LocalDateTime dataDeCriacao;
    private LocalDateTime dataDeAtualizacao;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String celular, String email, String cpf, LocalDate dataDeNascimento, LocalDateTime dataDeCriacao, LocalDateTime dataDeAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.dataDeCriacao = dataDeCriacao;
        this.dataDeAtualizacao = dataDeAtualizacao;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
