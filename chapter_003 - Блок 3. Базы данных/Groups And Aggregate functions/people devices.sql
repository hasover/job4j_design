create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

insert into devices(name, price) VALUES ('iPhone X', 45000.56);
insert into devices(name, price) VALUES ('Samsung Galaxy', 24000);
insert into devices(name, price) VALUES ('ZTE Blade A3', 4100.75);
insert into devices(name, price) VALUES ('Vsmart Bee', 4500);

create table people (
    id serial primary key,
    name varchar(255)
);

insert into people(name) VALUES ('Иван');
insert into people(name) VALUES ('Мария');
insert into people(name) VALUES ('Женя');
insert into people(name) VALUES ('Саша');

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices_people(device_id, people_id) VALUES (1,1);
insert into devices_people(device_id, people_id) VALUES (2,1);
insert into devices_people(device_id, people_id) VALUES (3,1);
insert into devices_people(device_id, people_id) VALUES (4,1);
insert into devices_people(device_id, people_id) VALUES (2,2);
insert into devices_people(device_id, people_id) VALUES (4,2);
insert into devices_people(device_id, people_id) VALUES (4,3);
insert into devices_people(device_id, people_id) VALUES (2,4);
insert into devices_people(device_id, people_id) VALUES (3,4);

select avg(price) from devices;

select p.name, avg(d.price) as Средняя_цена from
(people p join devices_people dp on p.id = dp.people_id) join devices d on d.id = dp.device_id
group by p.name;

select p.name, avg(d.price) as Средняя_цена from
    (people p join devices_people dp on p.id = dp.people_id) join devices d on d.id = dp.device_id
where d.price > 5000
group by p.name;