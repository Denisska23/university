DROP TABLE IF EXISTS employees CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS id_cards CASCADE;
DROP TABLE IF EXISTS lectures CASCADE;
DROP TABLE IF EXISTS students CASCADE;

CREATE TABLE id_cards
(
    id          SERIAL PRIMARY KEY,
    number      INT,
    date_expire timestamp without time zone
);

CREATE TABLE course
(
    id          VARCHAR(3) PRIMARY KEY unique,
    system_info VARCHAR(50)
);

CREATE TABLE employees
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    position   VARCHAR(50),
    id_card_id INT,
    FOREIGN KEY (id_card_id) REFERENCES id_cards (id)
);

CREATE TABLE lectures
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50),
    date timestamp without time zone,
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees (id)
);

CREATE TABLE groups
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50),
    lecture_id INT,
    FOREIGN KEY (lecture_id) references lectures (id)
);

CREATE TABLE students
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    course_id VARCHAR(3),
    group_id   INT,
    FOREIGN KEY (group_id) references groups (id),
    FOREIGN KEY (course_id) references course (id)
);

insert into course(id, system_info)
VALUES ('I', 'Запахи');
insert into course(id, system_info)
VALUES ('II', 'Духи');
insert into course(id, system_info)
VALUES ('III', 'Салаги');
insert into course(id, system_info)
VALUES ('IV', 'Дембеля');
insert into course(id, system_info)
VALUES ('V', 'Высшая сила');

insert into groups(id, name)
VALUES (1, 'First test group');


insert into students(id, first_name, last_name, course_id, group_id)
VALUES (1, 'John', 'Week','V',1);


