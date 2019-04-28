/* TODO: check NOT NULL constraints for foreign keys (to be able to insert rows and according to domain) */

CREATE TABLE university
(
    university_id serial PRIMARY KEY,
    name          VARCHAR(100) NOT NULL /* название университета */
);

CREATE TABLE department -- подразделение
(
    department_id serial PRIMARY KEY,
    faculty       VARCHAR(100) NOT NULL, /* место учёбы -- факультет */
    university_id INTEGER      NOT NULL REFERENCES university (university_id)
);

CREATE TABLE speciality -- специализация
(
    speciality_id serial PRIMARY KEY,
    name          VARCHAR(100) NOT NULL, /* название специальности -- 09.03.04 – Разработка программно-информационных систем (Академический магистр) */
    standard      VARCHAR(10)  NOT NULL, /* тип стандарта обучения -- старый/новый */
    department_id INTEGER      NOT NULL REFERENCES department (department_id)
);

CREATE TYPE person_type AS ENUM ('student', 'professor');

CREATE TABLE person
(
    person_id   serial PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    surname     VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20),
    person_type person_type NOT NULL
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
    grade_date    timestamp NOT NULL, /* дата проставления баллов */
    person_id     INTEGER   NOT NULL REFERENCES person (person_id),
    discipline_id INTEGER   NOT NULL REFERENCES discipline (discipline_id),
    UNIQUE (person_id, discipline_id)
);

CREATE TABLE education -- учёба
(
    education_id   serial PRIMARY KEY,
    education_type VARCHAR(100) NOT NULL, -- вид обучения -- бюджет/контракт
    education_form VARCHAR(100) NOT NULL, -- форма обучения -- очная/заочная
    qualification  VARCHAR(100) NOT NULL, -- квалификация -- магистр
    start_date     DATE         NOT NULL, -- дата начала
    end_date       DATE,                  -- дата конца
    course         SMALLINT     NOT NULL, -- курс
    speciality_id  INTEGER      NOT NULL REFERENCES speciality (speciality_id),
    person_id      INTEGER      NOT NULL REFERENCES person (person_id)
);

CREATE TABLE work
(
    work_id    serial PRIMARY KEY,
    position   VARCHAR(20) NOT NULL, -- должность
    work_start DATE        NOT NULL, -- начало работы
    work_end   DATE,                 -- конец работы
    person_id  INTEGER     NOT NULL REFERENCES person (person_id)
);

CREATE TABLE work_discipline
(
    -- many to many от должности (работы) к дисциплинам
    work_id       INTEGER NOT NULL REFERENCES work (work_id),
    discipline_id INTEGER NOT NULL REFERENCES discipline (discipline_id),
    PRIMARY KEY (work_id, discipline_id)
);

INSERT INTO person(name, surname, middle_name, person_type)
VALUES ('Иван', 'Иванов', 'Иванович', 'student');
