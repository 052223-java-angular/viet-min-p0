drop table if exists roles cascade;
drop table if exists users cascade;
drop table if exists reviews cascade;
drop table if exists products cascade;
drop table if exists orders cascade;

drop table if exists cart cascade;
drop table if exists cart_items cascade;
drop table if exists order_items cascade;
drop table if exists payment cascade;



create table roles(
    id varchar primary key,
    name varchar not null
);

create table users(
    id varchar primary key,
    username varchar unique,
    password varchar not null,
    role_id varchar not null,

    foreign key (role_id) references roles (id)
);

create table cart(
    id varchar primary key,
    user_id varchar not null,
    total decimal not null,

    foreign key (user_id) references users (id)
);

create table products(
    id varchar primary key,
    name varchar not null,
    price decimal not null,
    category varchar not null
);

create table cart_items(
    id varchar primary key,
    session_id varchar not null,
    product_id varchar not null,
    quantity int not null,

    foreign key (session_id) references cart (id),
    foreign key (product_id) references products (id)
);

create table reviews(
    id varchar primary key,
    rating integer not null,
    comment varchar not null,
    user_id varchar not null,
    product_id varchar not null,

    foreign key (user_id) references users (id),
    foreign key (product_id) references products (id)
);

create table orders(
    id varchar primary key,
    user_id varchar not null,
    product_id varchar not null,
    quantity integer not null,
    unit_price decimal not null,

    foreign key (user_id) references users (id),
    foreign key (product_id) references products (id)
);

create table order_items(
    id varchar primary key,
    order_id varchar not null,
    product_id varchar not null,
    quantity int not null,

    foreign key (order_id) references orders (id),
    foreign key (product_id) references products (id)
);

create table payment(
    id varchar primary key,
    order_id varchar not null,
    payment_number int,

    foreign key (order_id) references orders (id)
);