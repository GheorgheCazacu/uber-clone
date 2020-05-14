CREATE DATABASE uber_driver;
USE uber_driver;

CREATE TABLE driver (
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(128) not null,
phone_number varchar(24) null);

INSERT INTO uber_driver.driver (name, phone_number) VALUES ('First Driver', '07237231');
INSERT INTO uber_driver.driver(name, phone_number) VALUES ('Second Driver', '07237232');
INSERT INTO uber_driver.driver (name, phone_number) VALUES ('Third Driver', '07237233');
INSERT INTO uber_driver.driver (name, phone_number) VALUES ('Forth Driver', '07237233');


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
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Mazda CX30', 'RED soul', 'B121RED', '2020-01-01 18:08:10', 1, 'T');
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Mazda 6', 'Green', 'B09GREEN', '2018-01-02 10:05:12', 1, 'F');
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Mazda 3', 'Blue', 'B09BLUE', '2019-07-04 16:09:32', 1, 'F');
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Mazda 3', 'YELLOW', 'VN01ALB', '2019-08-01 12:01:01', 1, 'F');

INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Volvo S60', 'Blue', 'B89ALL', '2018-01-01 18:08:10', 2, 'F');
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Volvo S40', 'RED', 'BZ99LOL', '2017-01-01 18:08:10', 2, 'F');
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('Volvo X1', 'Stream', 'BZ99LOL', '2020-05-01 18:08:10', 2, 'T');
INSERT INTO uber_vehicle.vehicle (name, color, registration_number, register_timestamp, driver_id, active)
VALUES ('BMW X3', 'Rainbow', 'AB11POL', '2018-11-10 18:08:10', 2, 'F');



CREATE DATABASE uber_trip;
USE uber_trip;

create table trip (
id INT PRIMARY KEY AUTO_INCREMENT,
driver_id int not null,
start varchar(32) not null,
end varchar(32) not null,
start_time timestamp not null,
end_time timestamp null
);
INSERT INTO uber_trip.trip (driver_id, start, end, start_time, end_time)
VALUES (1, 'X1,Y1,Z1', 'X2,Y2,Z2', '2019-01-09 15:48:23', '2019-01-09 16:48:23');
INSERT INTO uber_trip.trip (driver_id, start, end, start_time, end_time)
VALUES (1, 'X1A,Y1A,Z1A', 'X2A,Y2A,Z2A', '2020-01-09 15:48:23', '2020-01-09 16:48:23');
INSERT INTO uber_trip.trip (driver_id, start, end, start_time, end_time)
VALUES (1, 'X1B,Y1B,Z1B', 'X2B,Y2B,Z2B', '2020-04-05 08:09:10', '2020-04-05 08:09:10');
INSERT INTO uber_trip.trip (driver_id, start, end, start_time, end_time)
VALUES (3, 'X1B,Y1B,Z1B', 'X2B,Y2B,Z2B', '2020-04-06 10:49:10', '2020-04-06 11:09:10');

CREATE DATABASE uber_payment;
USE uber_payment;

create table payment_info (
id INT PRIMARY KEY AUTO_INCREMENT,
price DOUBLE not null,
start timestamp null,
end timestamp null,
trip_id int not null,
driver_id int not null
);

INSERT INTO uber_payment.payment_info (price, start, end, trip_id, driver_id)
VALUES (11, '2019-01-09 15:48:23', '2019-01-09 16:05:15', 1, 1);
INSERT INTO uber_payment.payment_info (price, start, end, trip_id, driver_id)
VALUES (200, '2019-01-09 15:48:23', '2019-01-09 16:05:15', 1, 1);

INSERT INTO uber_payment.payment_info (price, start, end, trip_id, driver_id)
VALUES (10, '2019-01-09 15:48:23', '2019-01-09 16:05:15', 4, 3);
INSERT INTO uber_payment.payment_info (price, start, end, trip_id, driver_id)
VALUES (150, '2019-01-09 15:48:23', '2019-01-09 16:05:15', 4, 3);

CREATE DATABASE uber_payment_server;
USE uber_payment_server;

create table payment_server (
id INT PRIMARY KEY AUTO_INCREMENT,
price DOUBLE not null,
status ENUM('PENDING_AUTHORIZATION', 'PENDING_CONFIRMATION', 'SUCCEEDED', 'FAILED') not null,
reason varchar(128) null,
reward double null);