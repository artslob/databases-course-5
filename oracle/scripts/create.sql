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
    work_end   DATE                   -- конец работы
);

CREATE TABLE discipline
(
    discipline_id INTEGER GENERATED by default on null as IDENTITY PRIMARY KEY,
    name          VARCHAR(100) NOT NULL -- название дисциплины
);

INSERT INTO person(person_id, name, surname, middle_name, birthday, birthplace, person_type)
VALUES (191950, 'Ivan', 'Ivanov', 'Ivanovich', TO_DATE('23/02/1994', 'DD/MM/YYYY'), 'Russia, Moscow', 'student');

SELECT *
FROM person;
