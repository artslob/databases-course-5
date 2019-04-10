/* TODO: merge student and professor? */
/* TODO: create foreign keys */

CREATE TABLE student
(
    student_id  serial PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    surname     VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20)
);

CREATE TABLE professor
(
    professor_id serial PRIMARY KEY,
    name         VARCHAR(20) NOT NULL,
    surname      VARCHAR(20) NOT NULL,
    middle_name  VARCHAR(20)
);

CREATE TABLE university
(
    university_id serial PRIMARY KEY,
    name          VARCHAR(100) NOT NULL /* название университета */

);


CREATE TABLE discipline
(
    discipline_id     serial PRIMARY KEY,
    name              VARCHAR(100) NOT NULL, /* название дисциплины */
    lectures          INTEGER      NOT NULL, /* лекции: кол-во часов */
    practical_lessons INTEGER      NOT NULL, /* практические занятия: кол-во часов */
    labs              INTEGER      NOT NULL, /* лабораторные: кол-во часов */
    control_form      VARCHAR(10)  NOT NULL, /* форма контроля */
    semester          INTEGER      NOT NULL /* семестр */
);

CREATE TABLE speciality
(
    discipline_id    serial PRIMARY KEY,
    name             VARCHAR(100) NOT NULL, /* название специальности */
    educational_form VARCHAR(100) NOT NULL, /* форма обучения */
    standard         VARCHAR(10)  NOT NULL /* тип стандарта обучения */


);

CREATE TABLE grade
(
    grade_id serial PRIMARY KEY,
    grade    INTEGER   NOT NULL, /* баллы */
    date     timestamp NOT NULL /* дата проставления баллов */
);

INSERT INTO student(name, surname, middle_name)
VALUES ('Иван', 'Иванов', 'Иванович');
