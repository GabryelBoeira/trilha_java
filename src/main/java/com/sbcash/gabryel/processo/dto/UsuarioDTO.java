package com.sbcash.gabryel.processo.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbcash.gabryel.processo.entity.jpa.UsuarioEntity;


import java.sql.CallableStatement;
import java.time.LocalDate;

public class UsuarioDTO {

    private Long id;

    private String nome;

    private String sobreNome;

    private LocalDate dataNascimento;

    private String cpf;

    private String email;

    public UsuarioDTO(UsuarioEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobreNome = entity.getSobreNome();
        this.dataNascimento = entity.getDataNascimento();
        this.cpf = entity.getCpf();
        this.email = entity.getCpf();
    }

    public UsuarioDTO() {
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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
