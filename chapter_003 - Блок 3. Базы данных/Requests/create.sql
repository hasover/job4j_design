create database requests;

create table role(
    id serial primary key,
    name varchar(255)
);
insert into role(name) values ('client');
insert into role(name) values ('operator');

create table rule(
    id serial primary key,
    name varchar(255)
);
insert into rule(name) values ('Create the request');
insert into rule(name) values ('Cancel the request');
insert into rule(name) values ('Fulfil the request');

create table role_rule (
    id serial primary key,
    role_id int references role(id),
    rule_id int references rule(id)
);
insert into role_rule(role_id, rule_id) values (1,1);
insert into role_rule(role_id, rule_id) values (1,2);
insert into role_rule(role_id, rule_id) values (2,2);
insert into role_rule(role_id, rule_id) values (2,3);

create table users (
    id serial primary key,
    name varchar(255),
    role_id int references role(id)
);
insert into users(name, role_id) values ('client1', 1);
insert into users(name, role_id) values ('operator1', 2);

create table state (
    id serial primary key,
    name varchar(255)
);
insert into state(name) values ('pending');
insert into state(name) values ('completed');

create table category(
    id serial primary key,
    name varchar(255)
);
insert into category(name) values ('account settings');
insert into category(name) values ('program management');

create table item (
    id serial primary key,
    name varchar(255),
    user_id int references users(id),
    state_id int references state(id),
    category_id int references category(id)
);
insert into item(name, user_id, state_id, category_id)
             values ('Reset password', 1, 1, 1);

create table comments(
    id serial primary key,
    name varchar(255),
    item_id int references item(id)
);
insert into comments(name, item_id) values ('create new pass', 1);

create table attachs(
    id serial primary key,
    file_names varchar(255),
    item_id int references item(id)
);
insert into attachs(file_names, item_id) values ('file.txt', 1);