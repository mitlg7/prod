drop
    database if exists work;
create
    database work;

create table category
(
    id   integer primary key GENERATED BY DEFAULT AS IDENTITY,
    type varchar(250) not null unique
);

create table sub_category
(
    id          integer primary key GENERATED BY DEFAULT AS IDENTITY,
    type        varchar(250) not null unique,
    category_id integer,
    foreign key (category_id) references category (id)
);

create table role
(
    id   integer primary key GENERATED BY DEFAULT AS IDENTITY,
    type varchar(50) not null unique
);
create table user_info
(
    id       integer primary key GENERATED BY DEFAULT AS IDENTITY,
    name     varchar(250) not null,
    lastName varchar(250),
    phone    varchar(250),
    image    varchar(512),
    birthday date         not null
);


create table users
(
    id       integer primary key GENERATED BY DEFAULT AS IDENTITY,
    login    varchar(250) not null unique,
    password varchar(250) not null,
    email    varchar(250),
    info_id  integer,
    role_id  integer,
    foreign key (role_id) references role (id),
    foreign key (info_id) references user_info (id) on delete cascade on update cascade
);


create table product
(
    id              integer primary key GENERATED BY DEFAULT AS IDENTITY,
    user_id         integer       not null,
    name            varchar(250)  not null,
    image           varchar(512)  not null,
    description     varchar(1024) not null,
    date            date,
    price           varchar       not null,
    category_id     integer,
    sub_category_id integer,
    foreign key (user_id) references users (id),
    foreign key (category_id) references category (id),
    foreign key (sub_category_id) references sub_category (id)
);

create table item
(
    id          integer primary key GENERATED BY DEFAULT AS IDENTITY,
    name        varchar(250) not null,
    image       varchar(512),
    date        date,
    description varchar(4096),
    user_id     integer,
    foreign key (user_id) references users (id)
);


create table comment
(
    id      integer primary key GENERATED BY DEFAULT AS IDENTITY,
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


\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

CREATE PROCEDURE CREATE_USER(_login varchar, _password varchar, _email varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO users(LOGIN, PASSWORD, EMAIL, ROLE_ID)
    VALUES (_login, _password, _email, (SELECT ID FROM role WHERE type = 'USER'));
    COMMIT;
end;
$$;

CREATE PROCEDURE USER_GET(in _id int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    select u.id, u.login, u.password, r.type as role
    from users u
             join role r on r.id = u.role_id
    where u.id = _id;
END;
$$;


CREATE PROCEDURE REMOVE_USER(_login varchar)
    LANGUAGE plpgsql
as
$$
BEGIN
    delete from users where login = _login;
END;
$$;


CREATE PROCEDURE FIND_USER(_login varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    SELECT u.id, u.login, u.email, r.type
    FROM users u
             join role r on u.role_id = r.id
    where u.login = _login;
END;
$$;


CREATE PROCEDURE CREATE_PRODUCT(
    _USER_ID integer,
    _NAME varchar,
    _DESCRIPTION varchar,
    _PRICE varchar,
    _DATE date
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    insert into product (user_id, name, description, price, date)
    values (_USER_ID, _NAME, _DESCRIPTION, _PRICE, _DATE);
END;
$$;

CREATE PROCEDURE remove_product(_product_id integer)
    LANGUAGE plpgsql
AS
$$
BEGIN
    delete from product where id = _product_id;
END;
$$;


CREATE PROCEDURE CREATE_ITEM(
    _NAME varchar,
    _IMAGE varchar,
    _DATE date,
    _DESCRIPTION varchar,
    _USER_ID integer
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO item (name, image, date, description, user_id)
    VALUES (_NAME, _IMAGE, _DATE, _DESCRIPTION, _USER_ID);
END;
$$;

create procedure remove_item(_item_id integer)
    language plpgsql
as
$$
begin
    delete
    from item
    where id = _item_id;
end;
$$;


create procedure create_comment(_USER_ID integer,_DATE date, _MESSAGE varchar, _ITEM_ID integer)
    language plpgsql
as
$$
begin
    insert into comment (date, user_id, message, item_id)
    values (_DATE, _USER_ID, _MESSAGE, _ITEM_ID);
end;
$$;

create procedure remove_comment(_comment_id integer)
    language plpgsql
as
$$
begin
    delete
    from comment
    where id = _comment_id;
end;
$$;


create procedure create_category(_type varchar)
    language plpgsql
as
$$
begin
    insert into category (type)
    values (_type);
end;
$$;

create procedure remove_category(_category_id integer)
    language plpgsql
as
$$
begin
    delete
    from comment
    where id = _category_id;
end;
$$;