CREATE DATABASE Trampo_360;

USE Trampo_360;

CREATE TABLE aluno (
    id_Aluno INTEGER PRIMARY KEY auto_increment,
	CPF VARCHAR (40),
	email VARCHAR (80),
    nome VARCHAR (40),
    senha VARCHAR (40)
);

select * from aluno;

insert into aluno values (default, '234.324.333-29', 'fernanda@gmail.com', 'Fernanda', '123');
insert into aluno values (default, '222.222.333-44', 'diego@gmail.com', 'Diego', '345');
insert into aluno values (default, '333.333.444-55', 'otavio@gmail.com', 'Otavio', '123');
insert into aluno values (default, '444.444.555-66', 'bruna@gmail.com', 'Bruna','345');