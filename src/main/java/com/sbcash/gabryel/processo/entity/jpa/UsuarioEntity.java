package com.sbcash.gabryel.processo.entity.jpa;

import com.sbcash.gabryel.processo.dto.UsuarioDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USUARIO", schema = "public")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq_generator")
    @SequenceGenerator(name = "usuario_seq_generator", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    private Long id;

    private String nome;

    @Column(name = "sobre_nome")
    private String sobreNome;

    @Column(name= "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 11)
    private String cpf;

    private String email;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nome, String sobreNome, LocalDate dataNascimento, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
    }

    public UsuarioEntity(UsuarioDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.sobreNome = dto.getSobreNome();
        this.dataNascimento = dto.getDataNascimento();
        this.cpf = dto.getCpf();
        this.email = dto.getCpf();
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
