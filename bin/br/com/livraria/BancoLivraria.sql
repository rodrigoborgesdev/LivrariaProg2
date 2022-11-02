DROP DATABASE IF EXISTS livraria;
CREATE DATABASE livraria;
USE livraria;

DROP TABLE livro;

CREATE TABLE livro (
	id int auto_increment NOT NULL,
	titulo VARCHAR(50),
    editora VARCHAR(50),
    categoria VARCHAR(50),
    ano int,
    valor double,
    PRIMARY KEY(id)
);

INSERT INTO livro (id, titulo, editora, categoria, ano, valor) VALUES
(1, 'O Poder do Subconsciente', 'Record', 'Desenvolvimento Pessoal', 2010, 37.00);

INSERT INTO livro (id, titulo, editora, categoria, ano, valor) VALUES
(2, 'Os Segredos da Mente Milionária', 'Buzz', 'Desenvolvimento Pessoal', 2005, 45.00)