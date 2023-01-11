CREATE TABLE car_infos (
    id serial CONSTRAINT car_infos_pk PRIMARY KEY,
    colour VARCHAR(25),
    city VARCHAR(255),
    country VARCHAR(255),
    date TIMESTAMP,
    about TEXT
);