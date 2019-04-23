CREATE TABLE person
(
    person_id   INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    name        VARCHAR2(20)  NOT NULL,
    surname     VARCHAR2(20)  NOT NULL,
    middle_name VARCHAR2(20),
    birthday    DATE          NOT NULL,
    birthplace  VARCHAR2(100) NOT NULL,
    person_type VARCHAR2(20) CHECK ( person_type IN ('student', 'professor') )
);

CREATE TABLE work
(
    work_id    INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    position   VARCHAR2(20) NOT NULL, -- должность
    work_start DATE         NOT NULL, -- начало работы
    work_end   DATE,                  -- конец работы
    person_id  INTEGER      NOT NULL REFERENCES person (person_id)
);

CREATE TABLE schedule -- расписание
(
    schedule_id      INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    classroom        VARCHAR2(100), -- аудитория
    time_description VARCHAR2(200)  -- время
);

CREATE TABLE department -- подразделение
(
    department_id INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    faculty       VARCHAR2(100) NOT NULL, -- Факультет -- Мегафакультет / Факультет учёбы (работы)
    direction     VARCHAR2(100) NOT NULL, -- Направление -- 09.04.04 – Программная инженерия
    specialty     VARCHAR2(100) NOT NULL  -- Специальность -- 09.03.04 – Разработка программно-информационных систем(Академический магистр)
);

CREATE TABLE discipline -- дисциплина
(
    discipline_id INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    name          VARCHAR2(100) NOT NULL, -- название дисциплины
    department_id INTEGER REFERENCES department (department_id)
);

CREATE TABLE education -- учёба
(
    education_id   INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    education_type VARCHAR2(100) NOT NULL, -- вид обучения -- бюджет/контракт
    education_form VARCHAR2(100) NOT NULL, -- форма обучения -- очная/заочная
    qualification  VARCHAR2(100) NOT NULL, -- квалификация -- магистр
    start_date     DATE          NOT NULL, -- дата начала
    end_date       DATE,                   -- дата конца
    course         SMALLINT      NOT NULL, -- курс
    department_id  INTEGER REFERENCES department (department_id)
);

CREATE TABLE person_education
(
    -- many to many от студента к курсам учёбы
    person_id    INTEGER NOT NULL REFERENCES person (person_id),
    education_id INTEGER NOT NULL REFERENCES education (education_id)
);

CREATE TABLE grade -- оценка
(
    grade_id      INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    letter        CHAR(1) CHECK ( letter IN ('A', 'B', 'C', 'D', 'E', 'F') ), -- буква
    grade_date    DATE    NOT NULL,                                           -- дата получения
    person_id     INTEGER NOT NULL REFERENCES person (person_id),
    discipline_id INTEGER NOT NULL REFERENCES discipline (discipline_id),
    UNIQUE (person_id, discipline_id)
);

INSERT INTO person(person_id, name, surname, middle_name, birthday, birthplace, person_type)
VALUES (191950, 'Ivan', 'Ivanov', 'Ivanovich', TO_DATE('23/02/1994', 'DD/MM/YYYY'), 'Russia, Moscow', 'student');

SELECT *
FROM person;
