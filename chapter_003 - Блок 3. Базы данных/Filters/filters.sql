create table type(
    id serial primary key,
    name varchar(255)
);

insert into type(name) VALUES ('Сыр');
insert into type(name) VALUES ('Мороженое');
insert into type(name) VALUES ('Колбаса');
insert into type(name) VALUES ('Молоко');

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price float
);

insert into product(name, type_id, expired_date, price) VALUES ('Гауда', 1,'15.12.2020',320);
insert into product(name, type_id, expired_date, price) VALUES ('Голандский', 1,'20.01.2021',250);
insert into product(name, type_id, expired_date, price) VALUES ('Чеддер', 1,'20.02.2021',400);

insert into product(name, type_id, expired_date, price) VALUES ('мороженое Пломбир', 2,'20.12.2020',50);
insert into product(name, type_id, expired_date, price) VALUES ('Стаканчик мороженое', 2,'02.01.2021',25);

insert into product(name, type_id, expired_date, price) VALUES ('Докторская', 3,'02.02.2021',250);
insert into product(name, type_id, expired_date, price) VALUES ('Салями', 3,'02.03.2021',500);
insert into product(name, type_id, expired_date, price) VALUES ('Ливерная', 3,'14.02.2021',130);

insert into product(name, type_id, expired_date, price) VALUES ('Деревенское', 4,'14.12.2020',55);

select product.name from product join type t on product.type_id = t.id where t.name = 'Сыр';
select name from product where name like '%мороженое%';
select name from  product where extract(month from current_date + interval '1 month')= extract(month from expired_date);
select name, price from product where price in (select max(price) from product);
select t.name, count(t.name) as Кол_во from product join type t on product.type_id = t.id group by t.name;
select product.name from product join type t on product.type_id = t.id where t.name = 'Сыр' or t.name = 'Молоко';
select t.name from product join type t on product.type_id = t.id group by t.name having count(product.id) < 10;
select p.name Наименование, t.name Тип from product p join type t on p.type_id = t.id;