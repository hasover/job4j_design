create table game_company(
    id serial primary key,
    name varchar(255),
    country varchar(255)
);

create table video_game(
    id serial primary key,
    name varchar (255),
    release_date date,
    company_id int references game_company(id)
);

insert into game_company(name, country) VALUES ('Rock Star Games', 'USA');
insert into game_company(name, country) VALUES ('Electronic Arts', 'USA');
insert into game_company(name, country) VALUES ('Konami', 'Japan');
insert into game_company(name, country) VALUES ('Battlestate Games', 'Russia');

insert into video_game(name, release_date, company_id) VALUES ('GTA 5', '01.01.2013', 1);
insert into video_game(name, release_date, company_id) VALUES ('Red dead redemption 2', '01.01.2018', 1);
insert into video_game(name, release_date, company_id) VALUES ('FIFA', '01.01.2020', 2);
insert into video_game(name, release_date, company_id) VALUES ('Resident Evil', '01.01.2016', 3);
insert into video_game(name, release_date, company_id) VALUES ('Escape from Tarkov', '01.01.2017', 4);

select vg.name as Название, gc.name as Студия from video_game vg join game_company gc on vg.company_id = gc.id;
select vg.name as Название, gc.name as Студия, gc.country as Страна from video_game vg join game_company gc on vg.company_id = gc.id WHERE country !='USA';
select vg.name as Название, vg.release_date as Год, gc.name as Студия from video_game vg join game_company gc on vg.company_id = gc.id WHERE release_date >='01.01.2017';