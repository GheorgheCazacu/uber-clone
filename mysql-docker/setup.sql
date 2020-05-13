CREATE DATABASE uber;
USE uber;

CREATE TABLE driver (
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(128) not null,
phone_number varchar(24) null);

CREATE TABLE vehicle (
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(128) not null,
color varchar(24) null,
registration_number varchar(24) null,
register_timestamp timestamp null,
driver_id int not null,
active char(1) not null, -- active True, False
FOREIGN KEY (driver_id) REFERENCES driver(id) ON DELETE CASCADE
);


create table trip (
id INT PRIMARY KEY AUTO_INCREMENT,
driver_id int not null,
start varchar(32) not null,
end varchar(32) not null,
FOREIGN KEY (driver_id) REFERENCES driver(id) ON DELETE CASCADE
);


create table payment (
id INT PRIMARY KEY AUTO_INCREMENT,
paid_price DOUBLE not null,
start timestamp null,
end timestamp null,
trip_id int not null,
FOREIGN KEY (trip_id) REFERENCES trip(id) ON DELETE CASCADE
);

INSERT INTO uber.driver (name, phone_number) VALUES ('First Driver', 'BZ01GOG');
INSERT INTO uber.driver(name, phone_number) VALUES ('Second Driver', 'B108EEE');
INSERT INTO uber.driver (name, phone_number) VALUES ('Third Driver', 'VN15ROG');


CREATE DATABASE payment;
USE payment;

create table payment_server (
id INT PRIMARY KEY AUTO_INCREMENT,
price DOUBLE not null,
status ENUM('PENDING_AUTHORIZATION', 'PENDING_CONFIRMATION', 'SUCCEEDED', 'FAILED') not null,
reason varchar(128) null,
reward double null);