/* TODO: check NOT NULL constraints for foreign keys (to be able to insert rows and according to domain) */

CREATE TYPE person_type AS ENUM ('student', 'professor');

CREATE TABLE person
(
    person_id   serial PRIMARY KEY,
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

INSERT INTO person(person_id, name, surname, middle_name, person_type)
VALUES -- students
       (191950, 'Ivan', 'Ivanov', 'Ivanovich', 'student'),
       (191951, 'Fedor', 'Fedorov', 'Fedorovich', 'student'),
       (191952, 'Aleksey', 'Alekseev', 'Alekseevich', 'student'),
       -- professors
       (75950, 'Dmitriy', 'Dmitriev', 'Dmitrievich', 'professor'),
       (75951, 'Artem', 'Artemiev', 'Artemievich', 'professor'),
       (75952, 'Kirill', 'Kirillov', 'Kirillovich', 'professor');

INSERT INTO university(university_id, name)
VALUES (1, 'ITMO'),
       (2, 'Saint Petersburg State University'),
       (3, 'Peter the Great St.Petersburg Polytechnic University');

INSERT INTO department(department_id, faculty, university_id)
VALUES -- itmo
       (1, 'Faculty of Software Engineering and Computer Systems', 1),
       (2, 'Faculty of Secure Information Technologies', 1),
       (3, 'Institute of Information and Navigation Systems', 1),
       -- spsu
       (4, 'Graduate School of Journalism and Mass Communication', 2),
       (5, 'Graduate School of Management', 2),
       (6, 'Institute of Earth Sciences', 2),
       -- spbpu
       (7, 'Department for Protecting Confidential Information', 3),
       (8, 'Safety and Security Office', 3),
       (9, 'Technopark “Polytechnic”', 3);

INSERT INTO speciality (speciality_id, name, standard, department_id)
VALUES (1, '01.01.01', 'new', 1),
       (2, '01.01.02', 'new', 2),
       (3, '01.01.03', 'new', 3),
       (4, '02.01.01', 'old', 4),
       (5, '02.01.02', 'old', 5),
       (6, '02.01.03', 'old', 6),
       (7, '03.01.01', 'old', 7),
       (8, '03.01.02', 'old', 8),
       (9, '03.01.03', 'old', 9);

INSERT INTO discipline (discipline_id, name, lectures, practical_lessons, labs, control_form, semester, speciality_id)
VALUES (1, 'graphics', 17, 17, 17, 'exam', 1, 1),
       (2, 'computers', 17, 17, 17, 'exam', 1, 2),
       (3, 'c/c++', 17, 17, 17, 'exam', 1, 3),
       (4, 'machine learning', 35, 35, 35, 'test', 2, 4),
       (5, 'ai', 35, 35, 35, 'test', 2, 5),
       (6, 'cryptography', 35, 35, 35, 'test', 2, 6),
       (7, 'java', 17, 17, 17, 'exam', 3, 7),
       (8, 'asm', 17, 17, 17, 'exam', 3, 8),
       (9, 'iso', 17, 17, 17, 'exam', 3, 9);

INSERT INTO grade(grade_id, grade, grade_date, person_id, discipline_id)
VALUES (1, 91, '2013-06-01', 191950, 1),
       (2, 92, '2013-06-02', 191950, 2),
       (3, 93, '2013-06-03', 191950, 3),
       (4, 94, '2013-06-04', 191951, 4),
       (5, 95, '2013-06-05', 191951, 5),
       (6, 96, '2013-06-06', 191951, 6),
       (7, 97, '2013-06-07', 191952, 7),
       (8, 98, '2013-06-08', 191952, 8),
       (9, 99, '2013-06-09', 191952, 9);

INSERT INTO education (education_id, education_type, education_form, qualification, start_date, end_date, course,
                       speciality_id, person_id)
VALUES (1, 'budget', 'distant', 'master', '2012-09-01', NULL, 1, 1, 191950),
       (2, 'budget', 'distant', 'master', '2012-09-01', NULL, 1, 1, 191950),
       (3, 'budget', 'distant', 'master', '2012-09-01', NULL, 1, 1, 191950),
       (4, 'budget', 'distant', 'master', '2012-09-01', NULL, 2, 2, 191951),
       (5, 'budget', 'distant', 'master', '2012-09-01', NULL, 2, 2, 191951),
       (6, 'budget', 'distant', 'master', '2012-09-01', NULL, 2, 2, 191951),
       (7, 'budget', 'distant', 'master', '2012-09-01', NULL, 3, 3, 191952),
       (8, 'budget', 'distant', 'master', '2012-09-01', NULL, 3, 3, 191952),
       (9, 'budget', 'distant', 'master', '2012-09-01', NULL, 3, 3, 191952);

INSERT INTO work (work_id, position, work_start, work_end, person_id)
VALUES (1, 'professor', '1999-06-01', NULL, 75950),
       (2, 'professor', '1999-06-02', NULL, 75951),
       (3, 'professor', '1999-06-03', NULL, 75952);

INSERT INTO work_discipline(work_id, discipline_id)
VALUES (1, 1),
       (2, 3),
       (3, 3);
