drop
database if exists work;
create
database work;

use
work;

create table user
(
    id       int primary key auto_increment,
    login    varchar(250) not null unique,
    password varchar(250) not null,
    email    varchar(250) not null,
    role_id  int,
    info_id  int,
    foreign key (role_id) references role (id) on delete cascade on update cascade,
    foreign key (info_id) references user_info (id) on delete cascade on update cascade
);

create table user_info
(
    id       int primary key auto_increment,
    name     varchar(250) not null,
    lastName varchar(250),
    phone    varchar(250),
    image    varchar(250),
    birthday date         not null
);

create table role
(
    id   int primary key auto_increment,
    type varchar(50) not null unique
);

create table category
(
    id   int primary key auto_increment,
    type varchar(250) not null unique
);

create table sub_category
(
    id   int primary key auto_increment,
    type varchar(250) not null unique
);

insert into role (type)
values ('ADMIN');
insert into role (type)
values ('MODER');

insert into user (login, password, role_id)
values ('admin', 'admin', (select id from role where type = 'ADMIN'));
insert into user (login, password, role_id)
values ('moder', 'moder', (select id from role where type = 'MODER'));

create table product
(
    id              int primary key auto_increment,
    name            varchar(250)  not null,
    image           varchar(250)  not null,
    description     varchar(1024) not null,
    date            date,
    price           decimal       not null,
    category_id     int,
    sub_category_id int,
    foreign key (category_id) references category (id) on delete cascade on update cascade,
    foreign key (sub_category_id) references sub_category (id) on delete cascade on update cascade
);