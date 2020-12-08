create table departments(
    id serial primary key,
    name varchar(255)
);

insert into departments(name) values ('Production');
insert into departments(name) values ('Research');
insert into departments(name) values ('IT');
insert into departments(name) values ('Marketing');

create table employees(
    id serial primary key,
    name varchar(255),
    d_id int references departments(id)
);
insert into employees(name, d_id) VALUES ('Alex', 1);
insert into employees(name, d_id) VALUES ('Mary', 2);
insert into employees(name, d_id) VALUES ('Zoe', 2);
insert into employees(name, d_id) VALUES ('Stan', null);
insert into employees(name, d_id) VALUES ('Dan', 4);
insert into employees(name, d_id) VALUES ('Chris', null);

--Выполнить запросы с left, right, full, cross соединениями
select * from employees left join departments d on employees.d_id = d.id;
select * from employees right join departments d on employees.d_id = d.id;
select * from employees full join departments d on employees.d_id = d.id;

--Используя left join найти работников, которые не относятся ни к одну из департаментов
select * from employees left join departments d on employees.d_id = d.id where employees.d_id is null;

-- Используя left и right join написать запросы, которые давали бы одинаковый результат.
select * from employees left join departments d on employees.d_id = d.id;
select * from departments right join employees e on departments.id = e.d_id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens(
    id serial primary key,
    name varchar(255),
    gender char
);
insert into teens(name, gender) VALUES ('Alex','M');
insert into teens(name, gender) VALUES ('Chris','M');
insert into teens(name, gender) VALUES ('Dan','M');
insert into teens(name, gender) VALUES ('Mary','F');
insert into teens(name, gender) VALUES ('Zoe','F');

select * from teens cross join teens t where teens.gender != t.gender;
