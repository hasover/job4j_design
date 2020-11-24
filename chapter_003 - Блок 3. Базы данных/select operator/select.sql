create database students;

create table students (
    id serial primary key,
    name varchar(255),
    enroll_data date,
    course int,
    speciality varchar(255)
);

insert into students(name, enroll_data, course, speciality) VALUES ('Petrov', '12.10.2015', 3, 'biology');
insert into students(name, enroll_data, course, speciality) VALUES ('Pavlov', '12.10.2014', 4, 'math');
insert into students(name, enroll_data, course, speciality) VALUES ('Dmitriev', '12.10.2016', 2, 'math');
insert into students(name, enroll_data, course, speciality) VALUES ('Sidorov', '12.10.2013', 5, 'math');
insert into students(name, enroll_data, course, speciality) VALUES ('Soloviev', '12.10.2016', 2, 'biology');
insert into students(name, enroll_data, course, speciality) VALUES ('Sorokin', '12.10.2016', 2, 'math');

select * from students;
select name, course, speciality from students;
select * from students where course = 2;
select * from students where enroll_data > '12.10.2015';
select * from students where name like 'S%' and course > 4;

select current_date;

select * from students order by speciality asc;
select distinct course from students;
select * from students limit 3;