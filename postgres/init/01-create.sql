CREATE TABLE rating
(
    rating_id  serial PRIMARY KEY,
    mark       INTEGER   NOT NULL,
    created_on TIMESTAMP NOT NULL
);

INSERT INTO rating(mark, created_on)
values (100, '11.02.2016');
