/* TODO: create foreign keys */

CREATE TYPE person_type AS ENUM ('student', 'professor');

CREATE TABLE person
(
    student_id  serial PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    surname     VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20),
    person_type person_type NOT NULL
);

CREATE TABLE university
(
    university_id serial PRIMARY KEY,
    name          VARCHAR(100) NOT NULL /* название университета */
);

CREATE TABLE speciality
(
    speciality_id    serial PRIMARY KEY,
    name             VARCHAR(100) NOT NULL, /* название специальности */
    educational_form VARCHAR(100) NOT NULL, /* форма обучения */
    standard         VARCHAR(10)  NOT NULL, /* тип стандарта обучения */
    university_id    INTEGER      NOT NULL REFERENCES university (university_id)
);

CREATE TABLE discipline
(
    discipline_id     serial PRIMARY KEY,
    name              VARCHAR(100) NOT NULL, /* название дисциплины */
    lectures          INTEGER      NOT NULL, /* лекции: кол-во часов */
    practical_lessons INTEGER      NOT NULL, /* практические занятия: кол-во часов */
    labs              INTEGER      NOT NULL, /* лабораторные: кол-во часов */
    control_form      VARCHAR(10)  NOT NULL, /* форма контроля */
    semester          INTEGER      NOT NULL, /* семестр */
    speciality_id     INTEGER      NOT NULL REFERENCES speciality (speciality_id)
);

CREATE TABLE grade
(
    grade_id serial PRIMARY KEY,
    grade    INTEGER   NOT NULL, /* баллы */
    date     timestamp NOT NULL /* дата проставления баллов */
);

INSERT INTO person(name, surname, middle_name, person_type)
VALUES ('Иван', 'Иванов', 'Иванович', 'student');
