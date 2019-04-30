CREATE DATABASE uni;

USE uni;

CREATE TABLE person
(
    person_id   INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20)                         NOT NULL,
    surname     VARCHAR(20)                         NOT NULL,
    middle_name VARCHAR(20),
    position    ENUM ('docent','bachelor','master') NOT NULL -- должность
);

CREATE TABLE reader_list
(
    list_id           INT PRIMARY KEY AUTO_INCREMENT, -- Читательский лист
    registration_date DATE       NOT NULL,            -- дата регистрации
    person_id         INT UNIQUE NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (person_id)
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
    reader_id   INT  NOT NULL, -- человек
    book_id     INT  NOT NULL, -- взял книгу
    obtain_date DATE NOT NULL, -- когда взял
    returned    DATE,          -- когда вернул
    FOREIGN KEY (reader_id) REFERENCES reader_list (list_id),
    FOREIGN KEY (book_id) REFERENCES book (book_id)
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
    conference_id INT NOT NULL, -- конференция
    person_id     INT NOT NULL, -- участник
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (conference_id) REFERENCES conference (conference_id),
    PRIMARY KEY (conference_id, person_id)
);

CREATE TABLE project
(
    project_id    INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(100) NOT NULL, -- Наименование научного проекта
    project_start DATE         NOT NULL, -- Период участия в проекте
    project_end   DATE
);

CREATE TABLE project_participants -- участники проекта
(
    project_id INT NOT NULL, -- научный проект
    person_id  INT NOT NULL, -- участник
    FOREIGN KEY (project_id) REFERENCES project (project_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    PRIMARY KEY (project_id, person_id)
);

CREATE TABLE publication
(
    publication_id INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL,      -- Наименование публикации
    type           ENUM ('article', 'theses'), -- статья/тезисы
    citation_index INT                         -- Индекс цитирования
);

CREATE TABLE publication_coauthors -- соавторы публикации
(
    publication_id INT NOT NULL, -- публикация
    person_id      INT NOT NULL, -- соавтор
    FOREIGN KEY (publication_id) REFERENCES publication (publication_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id),
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
    publication_id INT          NOT NULL,
    FOREIGN KEY (publication_id) REFERENCES publication (publication_id)
);

INSERT INTO person(person_id, name, surname, middle_name, position)
VALUES -- students
       (191950, 'Ivan', 'Ivanov', 'Ivanovich', 'bachelor'),
       (191951, 'Fedor', 'Fedorov', 'Fedorovich', 'bachelor'),
       (191952, 'Aleksey', 'Alekseev', 'Alekseevich', 'bachelor'),
       -- professors
       (75950, 'Dmitriy', 'Dmitriev', 'Dmitrievich', 'docent'),
       (75951, 'Artem', 'Artemiev', 'Artemievich', 'docent'),
       (75952, 'Kirill', 'Kirillov', 'Kirillovich', 'docent');

INSERT INTO reader_list(list_id, registration_date, person_id)
VALUES (1, '2005-5-1', 191950),
       (2, '2005-5-7', 191951),
       (3, '2005-5-11', 191952);

INSERT INTO book(book_id, title, author, publication_date)
VALUES (1, 'The Prince and the Pauper', 'Mark Twain', '1882-1-1'),
       (2, 'The Adventures of Tom Sawyer', 'Mark Twain', '1876-1-1'),
       (3, 'The Adventures of Huckleberry Finn', 'Mark Twain', '1884-1-1');

INSERT INTO reader_info(info_id, reader_id, book_id, obtain_date, returned)
VALUES (1, 1, 1, '2005-5-1', NULL),
       (2, 2, 2, '2005-5-3', NULL),
       (3, 3, 3, '2005-6-1', NULL);

INSERT INTO conference(conference_id, title, place, conference_date)
VALUES (1, 'JUG', 'Russia, Moscow', '2010-2-12'),
       (2, 'Pycon Russia', 'Russia, Yekaterinburg', '2015-2-12'),
       (3, 'highload++', 'Russia, Moscow', '2010-2-12'),
       (4, 'GopherCon Russia 2019', 'Russia, Moscow', '2019-04-1');

INSERT INTO conference_participants(conference_id, person_id)
VALUES (4, 191950),
       (4, 191951),
       (4, 191952),
       (4, 75950),
       (2, 75951),
       (2, 75952),
       (2, 191951),
       (1, 191952);

INSERT INTO project(project_id, title, project_start, project_end)
VALUES (1, 'ai in iot', '2008-7-04', NULL),
       (2, 'cryptography and hamsters', '2008-7-05', NULL),
       (3, 'blockchain, machine learning and ai', '2007-7-06', '2007-7-15');

INSERT INTO project_participants(project_id, person_id)
VALUES (1, 191950),
       (1, 191951),
       (1, 191952),
       (2, 191950),
       (2, 75950),
       (3, 191952);

INSERT INTO publication(publication_id, title, type, citation_index)
VALUES (1, 'Articles and AI', 'article', 25),
       (2, 'Machine Learning and Buzzwords', 'article', 17),
       (3, 'Theses about my procrastination', 'theses', 33);

INSERT INTO publication_coauthors(publication_id, person_id)
VALUES (1, 191950),
       (1, 75950),
       (2, 191951),
       (3, 191950),
       (3, 191951),
       (3, 75952);

INSERT INTO edition(edition_id, title, language, volume, place, type, publication_id)
VALUES (1, 'Water and AI', 'ru', 10, 'Moscow', 'vac', 1),
       (2, 'ML and buzzwords: my publication', 'eng', 15, 'SPb', 'rinc', 2),
       (3, 'Publication about my procrastination', 'ru', 13, 'Cherepovets', 'vac', 3);
