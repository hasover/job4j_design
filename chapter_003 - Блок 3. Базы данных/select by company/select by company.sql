create table company (
    id integer not null,
    name character varying,
    constraint company_pkey primary key(id)
);

create table person(
    id integer not null,
    name character varying,
     company_id integer,
    constraint  person_pkey primary key(id)

);

insert into company(id, name) values (1, 'company A');
insert into company(id, name) values (2, 'company B');
insert into company(id, name) values (3, 'company C');

insert into person(id, name, company_id) VALUES (1, 'Person 1', 1);
insert into person(id, name, company_id) VALUES (2, 'Person 2', 1);
insert into person(id, name, company_id) VALUES (3, 'Person 3', 1);
insert into person(id, name, company_id) VALUES (7, 'Person 7', 1);
insert into person(id, name, company_id) VALUES (4, 'Person 4', 2);
insert into person(id, name, company_id) VALUES (5, 'Person 5', 2);
insert into person(id, name, company_id) VALUES (6, 'Person 4', 3);

--names of all persons that are NOT in the company with id = 5
--- company name for each person
select person.name, company.name from person join company on person.company_id = company.id where company_id !=5;

-- Select the name of the company with the maximum number of persons + number of persons in this company
select company.name, count(*) from person join company on person.company_id = company.id
group by company.name
having count(*) = (select max(num) from (select count(*) num from person group by company_id) s1);