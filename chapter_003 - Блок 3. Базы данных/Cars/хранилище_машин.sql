create table car_body(
    id serial primary key,
    name varchar(255)
);
insert into car_body(name) values ('Седан'), ('Кабриолет'), ('Пикап');

create table engine(
    id serial primary key,
    volume float,
    horse_power int,
    fuel varchar(255)
);
insert into engine(volume, horse_power, fuel) VALUES (3.3, 450, 'бензин');
insert into engine(volume, horse_power, fuel) VALUES (2.5, 180, 'бензин');
insert into engine(volume, horse_power, fuel) VALUES (2.5, 143, 'дизель');
insert into engine(volume, horse_power, fuel) VALUES (3, 350, 'бензин');
insert into engine(volume, horse_power, fuel) VALUES (2.0, 110, 'дизель');


create table gear_box(
    id serial primary key,
    name varchar(255)
);

insert into gear_box(name) values ('Автоматическая'), ('Механическая'), ('Роботизированная');

create table cars(
    id serial primary key,
    name varchar(255),
    car_body_id int references car_body(id),
    engine_id int references engine(id),
    gear_box_id int references gear_box(id),
    drive_type varchar(255)
);

insert into cars(name, car_body_id, engine_id, gear_box_id, drive_type) VALUES
('BMW M3', 1, 1, 1, 'Задний'), ('Kia Rio', 1, 3, 2, 'Передний'),
('Audi A3', 2, 2, 1, 'Полный'), ('Porshe', 2, 1, 1, 'Задний'),
('Mazda BT 50', 3, 5, 2, 'Полный');

select * from cars
     join car_body cb on cars.car_body_id = cb.id
     join engine e on cars.engine_id = e.id
     join gear_box gb on cars.gear_box_id = gb.id;

select * from car_body left join cars c on car_body.id = c.car_body_id where c.id is null;
select * from engine left join cars c on engine.id = c.engine_id where c.id is null;
select * from gear_box left join cars c on gear_box.id = c.gear_box_id where c.id is null;
