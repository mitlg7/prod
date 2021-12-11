

create database suppliers;

create table category
(
    id   integer primary key  auto_increment,
    type varchar(250) unique not null
);

create table sub_category
(
    id          integer primary key auto_increment,
    type        varchar(250) unique not null,
    category_id integer,
    foreign key (category_id) references category (id)
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
    sub_category_id integer,
    foreign key (user_id) references users (id),
    foreign key (category_id) references category (id),
    foreign key (sub_category_id) references sub_category (id)
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

insert into users (login, password, role_id)
values ('admin', 'admin', (select id from role where type = 'ADMIN'));
insert into users (login, password, role_id)
values ('moder', 'moder', (select id from role where type = 'MODER'));
insert into users (login, password, role_id)
values ('user', 'user', (select id from role where type = 'USER'));

INSERT INTO category (type)
values ('Металл');
INSERT INTO category (type)
values ('Дерево');
INSERT INTO category (type)
values ('Камень');
INSERT INTO category (type)
values ('Пластик');

\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

create procedure getAllUsers()
select *
from users;
$

create procedure getAllCategory()
select *
from category;
$

create procedure getAllComment()
select *
from comment;
$

create procedure getAllItem()
select *
from item;
$

create procedure getAllSubCategory()
select *
from sub_category;
$


create procedure createUser(_login varchar(128), _password varchar(128), _email varchar(128))
insert into users (login, password, email, role_id)
values (_login, _password, _email, (SELECT ID FROM role WHERE type = 'USER'));

create procedure createProduct(_user_id int, _image varchar(128), _name varchar(128), _description varchar(256), _price int, _date date)
insert into product (user_id, image, name, description, price, date)
values (_user_id, _image, _name, _description, _price, _date);

create procedure createItem(_name varchar(128), _image varchar(128), _date date, _description varchar(128), _user_id integer)
insert into product (name, image, date, description, user_id)
values (_name, _image, _date, _description, _user_id);

