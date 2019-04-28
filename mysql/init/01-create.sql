CREATE DATABASE uni;

USE uni;

CREATE TABLE person
(
    person_id   INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20)                          NOT NULL,
    surname     VARCHAR(20)                          NOT NULL,
    middle_name VARCHAR(20),
    position    ENUM ('доцент','бакалавр','магистр') NOT NULL -- должность
);

CREATE TABLE reader_list
(
    list_id           INT PRIMARY KEY AUTO_INCREMENT, -- Читательский лист
    registration_date DATE       NOT NULL,            -- дата регистрации
    person_id         INT UNIQUE NOT NULL REFERENCES person (person_id)
);

CREATE TABLE book
(
    book_id          INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(100) NOT NULL, -- название
    author           VARCHAR(100) NOT NULL, -- автор
    publication_date DATE                   -- Дата публикации
);

CREATE TABLE reader_info
(
    info_id     INT PRIMARY KEY AUTO_INCREMENT,
    reader_id   INT  NOT NULL REFERENCES reader_list (list_id), -- человек
    book_id     INT  NOT NULL REFERENCES book (book_id),        -- взял книгу
    obtain_date DATE NOT NULL,                                  -- когда взял
    returned    DATE                                            -- когда вернул
);

CREATE TABLE conference
(
    conference_id   INT PRIMARY KEY AUTO_INCREMENT,
    title           VARCHAR(100) NOT NULL, -- Наименование конференции
    place           VARCHAR(100) NOT NULL, -- Место проведения конференции
    conference_date DATE         NOT NULL  -- Дата конференции
);

CREATE TABLE conference_participants -- участники конференции
(
    conference_id INT NOT NULL REFERENCES conference (conference_id), -- конференция
    person_id     INT NOT NULL REFERENCES person (person_id),         -- участник
    PRIMARY KEY (conference_id, person_id)
);

CREATE TABLE project
(
    project_id    INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(100) NOT NULL, -- Наименование научного проекта
    project_start DATE         NOT NULL, -- Период участия в проекте
    project_end   DATE         NOT NULL
);

CREATE TABLE project_participants -- участники проекта
(
    project_id INT NOT NULL REFERENCES project (project_id), -- научный проект
    person_id  INT NOT NULL REFERENCES person (person_id),   -- участник
    PRIMARY KEY (project_id, person_id)
);

CREATE TABLE publication
(
    publication_id INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL,     -- Наименование публикации
    type           ENUM ('статья', 'тезисы'), -- статья/тезисы
    citation_index INT                        -- Индекс цитирования
);

CREATE TABLE publication_coauthors -- соавторы публикации
(
    publication_id INT NOT NULL REFERENCES publication (publication_id), -- публикация
    person_id      INT NOT NULL REFERENCES person (person_id),           -- соавтор
    PRIMARY KEY (publication_id, person_id)
);

CREATE TABLE edition -- издание
(
    edition_id     INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL, -- Наименование издания
    language       VARCHAR(30)  NOT NULL, -- Язык издания
    volume         INT          NOT NULL, -- Объём издания -- 5 листов
    place          VARCHAR(100) NOT NULL, -- Место издания -- Тверь/Москва
    type           VARCHAR(50)  NOT NULL, -- Тип издания -- вак, ринц ....
    publication_id INT          NOT NULL REFERENCES publication (publication_id)
);

INSERT INTO person(name, surname, middle_name, position)
VALUES ('ivan', 'ivanov', 'petrovich', 'бакалавр');
