CREATE DATABASE uni;

USE uni;

CREATE TABLE test
(
    test_id INT PRIMARY KEY AUTO_INCREMENT,
    text    VARCHAR(30) NOT NULL
);

insert into test (text)
values ('test text');
