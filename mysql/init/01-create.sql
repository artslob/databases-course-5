CREATE DATABASE uni;

USE uni;

# TODO foreign keys to one line

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
    info_id INT PRIMARY KEY AUTO_INCREMENT,
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
    # TODO rename to conference_date
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
    project_id INT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(100) NOT NULL, # Наименование научного проекта
    # TODO rename it to project_start and project_end
    start      DATE         NOT NULL, # Период участия в проекте
    end        DATE         NOT NULL
);

CREATE TABLE project_participants # участники проекта
(
    project_id INT NOT NULL, # научный проект
    person_id  INT NOT NULL, # участник
    FOREIGN KEY (project_id) REFERENCES project (project_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    PRIMARY KEY (project_id, person_id)
);

CREATE TABLE publication
(
    publication_id INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL,     # Наименование публикации
    type           ENUM ('статья', 'тезисы'), # статья/тезисы
    citation_index INT                        # Индекс цитирования
);

CREATE TABLE publication_coauthors # соавторы публикации
(
    publication_id INT NOT NULL, # публикация
    person_id      INT NOT NULL, # соавтор
    FOREIGN KEY (publication_id) REFERENCES publication (publication_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    PRIMARY KEY (publication_id, person_id)
);

CREATE TABLE edition # издание
(
    edition_id     INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL, # Наименование издания
    language       VARCHAR(30)  NOT NULL, # Язык издания
    volume         INT          NOT NULL, # Объём издания -- 5 листов
    place          VARCHAR(100) NOT NULL, # Место издания -- Тверь/Москва
    type           VARCHAR(50)  NOT NULL, # Тип издания -- вак, ринц ....
    publication_id INT          NOT NULL,
    FOREIGN KEY (publication_id) REFERENCES publication (publication_id)
);

INSERT INTO person(name, surname, middle_name, position)
VALUES ('ivan', 'ivanov', 'petrovich', 'бакалавр');
