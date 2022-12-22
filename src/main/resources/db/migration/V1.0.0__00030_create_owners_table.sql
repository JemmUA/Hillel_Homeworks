CREATE TABLE owners (
    id serial CONSTRAINT owners_pk PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    gender VARCHAR(10),
    car_id INT,
    city VARCHAR(255),
    country VARCHAR(255),
    date TIMESTAMP,
    about TEXT
);