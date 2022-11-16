CREATE TABLE IF NOT EXISTS devices(
    id int auto_increment primary key,
    machine_id varchar(255),
    operating_system varchar(255),
    hostname varchar(255)
);

CREATE TABLE IF NOT EXISTS devices_resources (
    id int auto_increment primary key,
    device_id int,
    ram FLOAT,
    storage FLOAT,
    cpu FLOAT,
    time_s TIMESTAMP
);