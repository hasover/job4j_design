create table users (
id serial primary key,
name varchar
);

insert into users(name) values ('user1'), ('user2'), ('user3'), ('user4');

create table meetings (
id serial primary key,
 name varchar
);
insert into meetings(name) values ('meeting1'), ('meeting2'), ('meeting3');

create table status (
id serial primary key,
name varchar
);

insert into status(name) values ('confirmed'), ('declined');

create table meetings_users(
                               id serial primary key,
                               meeting_id int references meetings(id),
                               user_id int references users(id),
                               status_id int references status(id)
);
insert into meetings_users(meeting_id, user_id, status_id) VALUES
(1,1,1), (1,2,1), (1,3,1), (1,4,1),
(2,1,1), (2,2,2), (2,3,2), (2,4,1),
(3,1,2);

--Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников
SELECT meetings.name,count(user_id) as num_people
FROM meetings  join meetings_users mu on meetings.id = mu.meeting_id
Where mu.status_id = 1
GROUP BY meetings.name;


--Нужно получить все совещания, где не было ни одной заявки на посещения

SELECT meetings.name from

    (SELECT meeting_id, count(user_id) as num_people FROM meetings_users
     Where status_id = 1
     GROUP BY meeting_id) as meet_count

RIGHT JOIN meetings on meet_count.meeting_id = meetings.id
WHERE num_people is null;