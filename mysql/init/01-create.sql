CREATE DATABASE uni;

USE uni;

CREATE TABLE person
(
    person_id   INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20)                          NOT NULL,
    surname     VARCHAR(20)                          NOT NULL,
    middle_name VARCHAR(20),
    position    ENUM ('доцент','бакалавр','магистр') NOT NULL # должность
);

CREATE TABLE reader_list
(
    list_id           INT PRIMARY KEY AUTO_INCREMENT, # Читательский лист -- взял книгу, какую книгу, когда взял, когда вернул
    registration_date DATE NOT NULL                   # дата регистрации
);

CREATE TABLE book
(
    book_id          INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(100) NOT NULL, # название
    author           VARCHAR(100) NOT NULL, # автор
    publication_date DATE                   # Дата публикации
);

CREATE TABLE conference
(
    conference_id INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(100) NOT NULL, # Наименование конференции
    place         VARCHAR(100) NOT NULL, # Место проведения конференции
    date          DATE         NOT NULL  # Дата конференции
);

CREATE TABLE project
(
    # TODO Участники научного проекта
    project_id INT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(100) NOT NULL, # Наименование научного проекта
    start      DATE         NOT NULL, # Период участия в проекте
    end        DATE         NOT NULL
);

CREATE TABLE publication
(
    # TODO Соавторы
    publication_id INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL,     # Наименование публикации
    type           ENUM ('статья', 'тезисы'), # статья/тезисы
    citation_index INT                        # Индекс цитирования
);

CREATE TABLE edition
(
    edition_id INT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(100) NOT NULL, # Наименование издания
    language   VARCHAR(30)  NOT NULL, # Язык издания
    volume     INT          NOT NULL, # Объём издания -- 5 листов
    place      VARCHAR(100) NOT NULL, # Место издания -- Тверь/Москва
    type       VARCHAR(50)  NOT NULL  # Тип издания -- вак, ринц ....
);

INSERT INTO person(name, surname, middle_name, position)
VALUES ('ivan', 'ivanov', 'petrovich', 'бакалавр');
