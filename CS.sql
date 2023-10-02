create database CS4;
use CS4;
create table accounts(
account_id int primary key auto_increment,
account_name varchar(100),
`password` varchar(100),
is_delete bit(1) default 0,
`admin` bit(1) default 0,
`employee` bit(1) default 0
);

create table customers(
customer_id int primary key auto_increment,
customer_name varchar(100),
phone_number varchar(10),
email varchar(100),
account_id int,
is_delete bit(1) default 0,
foreign key (account_id) references accounts(account_id)
);
create table employees(
employee_id int primary key auto_increment,
employee_name varchar(100),
phone_number varchar(10),
email varchar(100),
identity_number varchar(12),
account_id int,
is_delete bit(1) default 0,
foreign key (account_id) references accounts(account_id)
);
create table yards(
yard_id int primary key auto_increment,
yard_name varchar(100),
address varchar(100),
highlight text,
price double,
`status` bit(1) default 0,
is_delete bit(1) default 0
);
create table booking(
booking_id int primary key auto_increment,
booking_date date,
`time` int,
deposit double,
yard_id int,
customer_id int,
is_delete bit(1) default 0,
foreign key(yard_id) references yards(yard_id),
foreign key(customer_id) references customers(customer_id)
);

