CREATE DATABASE uber_driver;
USE uber_driver;

CREATE TABLE driver (
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(128) not null,
phone_number varchar(24) null);

INSERT INTO uber_driver.driver (name, phone_number) VALUES ('First Driver', '07237231');
INSERT INTO uber_driver.driver(name, phone_number) VALUES ('Second Driver', '07237232');
INSERT INTO uber_driver.driver (name, phone_number) VALUES ('Third Driver', '07237233');


CREATE DATABASE uber_vehicle;
USE uber_vehicle;

CREATE TABLE vehicle (
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(128) not null,
color varchar(24) null,
registration_number varchar(24) null,
register_timestamp timestamp null,
driver_id int not null,
active char(1) not null
);

CREATE DATABASE uber_trip;
USE uber_trip;

create table trip (
id INT PRIMARY KEY AUTO_INCREMENT,
driver_id int not null,
start varchar(32) not null,
end varchar(32) not null
);

CREATE DATABASE uber_payment;
USE uber_payment;

create table payment (
id INT PRIMARY KEY AUTO_INCREMENT,
paid_price DOUBLE not null,
start timestamp null,
end timestamp null,
trip_id int not null
);

CREATE DATABASE uber_payment_server;
USE uber_payment_server;

create table payment_server (
id INT PRIMARY KEY AUTO_INCREMENT,
price DOUBLE not null,
status ENUM('PENDING_AUTHORIZATION', 'PENDING_CONFIRMATION', 'SUCCEEDED', 'FAILED') not null,
reason varchar(128) null,
reward double null);