/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Pierandrea
 * Created: 20-mag-2017
 */

--user: pieppo; pass: pieppo;

CREATE TABLE nerd(
    nerd_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256),
    cognome VARCHAR(256),
    pres VARCHAR(1024),
    password VARCHAR(256) NOT NULL,
    url_foto VARCHAR(256)
);

CREATE TABLE tipoPost(
    tipoPost_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    tipoPost_nome VARCHAR(32)
);

CREATE TABLE posts(
    post_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    autore INTEGER,
    contenuto VARCHAR(1024),
    url_allegato VARCHAR(256),
    tipo INTEGER,
    FOREIGN KEY (autore) REFERENCES nerd(nerd_id),
    FOREIGN KEY (tipo) REFERENCES tipoPost(tipoPost_id)
);

CREATE TABLE gruppi(
    gruppo_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    gruppo_nome VARCHAR(265)
);

CREATE TABLE membriGruppi(
    id_gruppo INTEGER,
    id_membro INTEGER,
    FOREIGN KEY (id_gruppo) REFERENCES gruppi(gruppo_id),
    FOREIGN KEY (id_membro) REFERENCES nerd(nerd_id),
    PRIMARY KEY(id_gruppo, id_membro)
);

CREATE TABLE postBacheca(
    proprietario INTEGER,
    id_post INTEGER,
    FOREIGN KEY (proprietario) REFERENCES nerd(nerd_id),
    FOREIGN KEY (id_post) REFERENCES posts(post_id),
    PRIMARY KEY(proprietario, id_post)
);

CREATE TABLE postGruppi(
    id_gruppo INTEGER,
    id_post INTEGER,
    FOREIGN KEY (id_gruppo) REFERENCES gruppi(gruppo_id),
    FOREIGN KEY (id_post) REFERENCES posts(post_id),
    PRIMARY KEY(id_gruppo, id_post)
);

--Popolamento tabella nerd

INSERT INTO nerd (nerd_id, nome, cognome, pres, password, url_foto)
VALUES (default,
        'Gigi',
        'Pintus',
        'Ciao!!',
        '1234',
        'img/Profile01.png');

INSERT INTO nerd (nerd_id, nome, cognome, pres, password, url_foto)
VALUES (default,
        'Wowo',
        'Pinna',
        'Hola!!',
        '1234',
        'img/Profile02.jpg');

INSERT INTO nerd (nerd_id, nome, cognome, pres, password, url_foto)
VALUES (default,
        'Gianni',
        'Scalas',
        'Yess!!',
        '1234',
        'img/Profile03.png');

INSERT INTO nerd (nerd_id, nome, password)
VALUES (default,
        'Incompleto',
        '1234');

--Popolamento tabella tipoPost

INSERT INTO tipoPost (tipoPost_id, tipoPost_nome)
VALUES (default,
        'TEXT');

INSERT INTO tipoPost (tipoPost_id, tipoPost_nome)
VALUES (default,
        'IMAGE');

--Popolamento tabella posts

INSERT INTO posts (post_id, autore, contenuto, tipo)
VALUES (default,
        '1',
        'Primo post in assoluto su Nerdbook!',
        '1');

INSERT INTO posts (post_id, autore, contenuto, url_allegato, tipo)
VALUES (default,
        '2',
        'Sono arrivato tardi',
        'img/allegato_post.jpg',
        '2');

INSERT INTO posts (post_id, autore, contenuto, tipo)
VALUES (default,
        '3',
        'Iscrivetevi a questo sito di cashback: http://it.beruby.com/promocode/uVjKCl',
        '1');

--Popolamento tabella gruppi

INSERT INTO gruppi (gruppo_id, gruppo_nome)
VALUES (default,
        'Consolari');

INSERT INTO gruppi (gruppo_id, gruppo_nome)
VALUES (default,
        'PCisti');

--Popolamento tabella membriGruppi

INSERT INTO membriGruppi (id_gruppo, id_membro)
VALUES ('1',
        '1');

INSERT INTO membriGruppi (id_gruppo, id_membro)
VALUES ('1',
        '2');

INSERT INTO membriGruppi (id_gruppo, id_membro)
VALUES ('2',
        '2');

INSERT INTO membriGruppi (id_gruppo, id_membro)
VALUES ('2',
        '3');

--Popolamento tabella postBacheca

INSERT INTO postBacheca (proprietario, id_post)
VALUES ('2',
        '1');

INSERT INTO postBacheca (proprietario, id_post)
VALUES ('1',
        '2');

INSERT INTO postBacheca (proprietario, id_post)
VALUES ('3',
        '3');

