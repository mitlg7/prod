

create database suppliers;

use suppliers;

create table category
(
    id   integer primary key  auto_increment,
    type varchar(250) unique not null
);

create table country
(
    id          integer primary key auto_increment,
    name        varchar(250) unique not null
);

create table role
(
    id   integer primary key auto_increment,
    type varchar(50) unique not null
);
create table user_info
(
    id       integer primary key auto_increment,
    name     varchar(250) not null,
    lastName varchar(250),
    phone    varchar(250),
    image    varchar(512),
    birthday date         not null
);


create table users
(
    id       integer primary key auto_increment,
    login    varchar(250) unique not null ,
    password varchar(250) not null,
    email    varchar(250),
    info_id  integer,
    role_id  integer,
    foreign key (role_id) references role (id),
    foreign key (info_id) references user_info (id) on delete cascade on update cascade
);


create table product

(
    id              integer primary key auto_increment,
    user_id         integer       not null,
    name            varchar(250)  not null,
    image           varchar(512)  not null,
    description     varchar(1024) not null,
    date            date,
    price           integer       not null,
    category_id     integer,
    country_id integer,
    foreign key (user_id) references users (id),
    foreign key (category_id) references category (id),
    foreign key (country_id) references country (id)
);

create table item
(
    id          integer primary key auto_increment,
    name        varchar(250) not null,
    image       varchar(512),
    date        date,
    description varchar(4096),
    user_id     integer,
    foreign key (user_id) references users (id)
);


create table comment
(
    id      integer primary key auto_increment,
    date    date    not null,
    user_id integer not null,
    message varchar(4096),
    item_id integer,
    foreign key (user_id) references users (id),
    foreign key (item_id) references item (id)

);

insert into role (type)
values ('ADMIN');
insert into role (type)
values ('MODER');
insert into role (type)
values ('USER');

insert into country (name)
values ('Россия');
insert into country (name)
values ('Германия');
insert into country (name)
values ('Китай');
insert into country (name)
values ('Америка');

insert into users (login, password, role_id)
values ('admin', '$2a$10$hUixmuP1Y0PqLpuqGwlY/.xuO.O1rDY8azyS7cCx05.fD2YRIZ5DO', (select id from role where type = 'ADMIN'));
insert into users (login, password, role_id)
values ('moder', '$2a$10$6ZEtqONqtv7OQ/Sr1ObOz.hLnVrkzqf8Z7baoCJ.vudKMd0OOnc72', (select id from role where type = 'MODER'));
insert into users (login, password, role_id)
values ('user', '$2a$10$AV3Ee0PERL7EqQnCodwGVuju6zJfExvPuHs1DvcdWLs294ZPUMzXy', (select id from role where type = 'USER'));

INSERT INTO category (type)
values ('Металл');
INSERT INTO category (type)
values ('Дерево');
INSERT INTO category (type)
values ('Камень');
INSERT INTO category (type)
values ('Пластик');

create procedure createUser(_login varchar(128), _password varchar(128), _email varchar(128))
insert into users (login, password, email, role_id)
values (_login, _password, _email, (SELECT ID FROM role WHERE type = 'USER'));

create procedure userGet(in _id int)
select u.id, u.login, u.password, r.type as role
from users u
         join role r on r.id = u.role_id
where u.id = _id;

create procedure removeUser(_login varchar(128))
delete from users where login = _login;

create procedure findUser(_login varchar(128))
SELECT u.id, u.login, u.email, r.type
FROM users u
         join role r on u.role_id = r.id
where u.login = _login;

create procedure allUsers() SELECT * FROM users;

create procedure allCountry() SELECT * FROM country;

create procedure allCountry() SELECT * FROM country;

create procedure userByLogin(_login varchar(128))
SELECT * FROM users where login = _login;

create procedure roleById(_id int)
SELECT *
FROM role
where id = _id;

create procedure categoryById(_id int)
SELECT *
FROM category
where id = _id;



create procedure userById(_id int )
SELECT * FROM users where id = _id;



create procedure createProduct(_user_id int, _image varchar(128), _name varchar(128), _description varchar(256), _price int, _date date, _cat_id int, _cntr int)
insert into product (user_id, image, name, description, price, date, category_id, country_id)
values (_user_id, _image, _name, _description, _price, _date, _cat_id, _cntr);

create procedure removeProduct(_id int)
delete from product where id = _id;


create procedure productById(_id int)
select * from product where id = _id;

create procedure productByUserId(_id int)
select * from product where user_id = _id;

create procedure itemByUserId(_id int)
select * from item where user_id = _id;

create procedure commentByItemId(_id int)
select * from comment where item_id = _id;


create procedure allProduct() SELECT * FROM product;





create procedure createItem(_name varchar(128), _image varchar(128), _date date, _description varchar(128), _user_id integer)
insert into item (name, image, date, description, user_id)
values (_name, _image, _date, _description, _user_id);

create procedure removeItem(_item_id int)
delete from item where id = _item_id;

create procedure allItem()
SELECT * FROM item;

create procedure itemById(_id int)
SELECT * FROM item where id = _id;




create procedure createComment(_user_id int, _date date, _message varchar(128), _item_id int)
insert into comment (user_id,  date, message, item_id)
values (_user_id, _date, _message, _item_id);

create procedure removeComment(_comment_id int)
delete from comment where id = _comment_id;


create procedure commentByUserId(_id int)
SELECT * FROM comment where user_id = _id;




create procedure createCategory(_type varchar(64))
insert into category (type) values (_type);

create procedure removeCategory(_category_id int)
delete from category where id = _category_id;

create procedure roleById(_id int)
SELECT *
FROM role
where id = _id;

create procedure countryById(_id int)
SELECT * FROM country
where id = _id;

create procedure allCountry()
SELECT * FROM country;

create procedure getCountyName(_name varchar(128))
SELECT * FROM country
where name = _name;


create procedure createUserInfo(_name varchar(128), _lastname varchar(128), _phone varchar(64), _image varchar(128),_birthday date)
insert into user_info (name, lastName, phone, image, birthday)
values (_name, _lastname, _phone, _image, _birthday);

create procedure userInfoById(_id int )
SELECT * FROM user_info where id = _id;

create procedure addUserInfoToUser(_login varchar(128))
UPDATE users SET info_id = @@IDENTITY   WHERE login = _login;










