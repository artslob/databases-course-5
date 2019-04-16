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
    list_id           INT PRIMARY KEY AUTO_INCREMENT, # Читательский лист
    registration_date DATE       NOT NULL,            # дата регистрации
    person_id         INT UNIQUE NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (person_id)
);

CREATE TABLE book
(
    book_id          INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(100) NOT NULL, # название
    author           VARCHAR(100) NOT NULL, # автор
    publication_date DATE                   # Дата публикации
);

CREATE TABLE reader_info
(
    reader_id   INT  NOT NULL, # человек
    book_id     INT  NOT NULL, # взял книгу
    obtain_date DATE NOT NULL, # когда взял
    returned    DATE,          # когда вернул
    FOREIGN KEY (reader_id) REFERENCES reader_list (list_id),
    FOREIGN KEY (book_id) REFERENCES book (book_id)
);

CREATE TABLE conference
(
    conference_id INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(100) NOT NULL, # Наименование конференции
    place         VARCHAR(100) NOT NULL, # Место проведения конференции
    date          DATE         NOT NULL  # Дата конференции
);

CREATE TABLE conference_participants # участники конференции
(
    conference_id INT NOT NULL, # конференция
    person_id     INT NOT NULL, # участник
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (conference_id) REFERENCES conference (conference_id),
    PRIMARY KEY (conference_id, person_id)
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
