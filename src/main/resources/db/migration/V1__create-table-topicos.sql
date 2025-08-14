CREATE TABLE topicos (

    id bigint NOT NULL auto_increment,
    titulo VARCHAR(100) NOT NULL,
    mensagem text NOT NULL,
    data_de_criacao datetime NOT NULL,
    estado_do_topico VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)

);