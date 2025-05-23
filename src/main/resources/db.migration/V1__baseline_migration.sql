CREATE SCHEMA IF NOT EXISTS public;
SET SCHEMA public;

CREATE SEQUENCE USUARIO_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    sobre_nome VARCHAR(255),
    cpf VARCHAR(14),
    email VARCHAR(255),
    data_nascimento DATE
);
