CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL
);

CREATE TABLE lancamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(19,2) NOT NULL,
    observacao TEXT,
    tipo VARCHAR(20) NOT NULL,
    categoria_id BIGINT NOT NULL,
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

