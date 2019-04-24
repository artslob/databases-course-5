/* TODO: check NOT NULL constraints for foreign keys (to be able to insert rows and according to domain) */

CREATE TABLE university
(
    university_id serial PRIMARY KEY,
    name          VARCHAR(100) NOT NULL /* название университета */
);

CREATE TABLE speciality
(
    speciality_id    serial PRIMARY KEY,
    name             VARCHAR(100) NOT NULL, /* название специальности -- 09.03.04 – Разработка программно-информационных систем (Академический магистр) */
    educational_form VARCHAR(100) NOT NULL, /* форма обучения -- очная/заочная */
    standard         VARCHAR(10)  NOT NULL, /* тип стандарта обучения -- старый/новый */
    faculty          VARCHAR(100) NOT NULL, /* место учёбы -- факультет */
    university_id    INTEGER      NOT NULL REFERENCES university (university_id)
);

CREATE TYPE person_type AS ENUM ('student', 'professor');

CREATE TABLE person
(
    person_id     serial PRIMARY KEY,
    name          VARCHAR(20) NOT NULL,
    surname       VARCHAR(20) NOT NULL,
    middle_name   VARCHAR(20),
    person_type   person_type NOT NULL,
    /* TODO: speciality for professor? add check that not null for student */
    speciality_id INTEGER REFERENCES speciality (speciality_id)
);

CREATE TABLE discipline
(
    discipline_id     serial PRIMARY KEY,
    name              VARCHAR(100) NOT NULL, /* название дисциплины -- Компьютерная графика (2018449043-И) */
    lectures          INTEGER      NOT NULL, /* лекции: кол-во часов */
    practical_lessons INTEGER      NOT NULL, /* практические занятия: кол-во часов */
    labs              INTEGER      NOT NULL, /* лабораторные: кол-во часов */
    control_form      VARCHAR(10)  NOT NULL, /* форма контроля -- экзамен / зачёт */
    semester          INTEGER      NOT NULL, /* семестр */
    speciality_id     INTEGER      NOT NULL REFERENCES speciality (speciality_id)
);

CREATE TABLE grade
(
    grade_id      serial PRIMARY KEY,
    grade         INTEGER   NOT NULL, /* баллы */
    -- TODO rename to grade_date
    date          timestamp NOT NULL, /* дата проставления баллов */
    person_id     INTEGER   NOT NULL REFERENCES person (person_id),
    discipline_id INTEGER   NOT NULL REFERENCES discipline (discipline_id),
    UNIQUE (person_id, discipline_id)
);

INSERT INTO person(name, surname, middle_name, person_type)
VALUES ('Иван', 'Иванов', 'Иванович', 'student');
