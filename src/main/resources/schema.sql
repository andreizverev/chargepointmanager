create table charge_points (
    unique_serial_number varchar primary key,
    name varchar not null
);

create table connectors (
    charge_point_unique_serial_number varchar references charge_points(unique_serial_number),
    number integer not null,
    primary key (charge_point_unique_serial_number, number)
);

create table vehicles (
    registration_plate varchar primary key,
    name varchar not null
);

create table rfid_tags (
    number integer primary key,
    name varchar not null,
    vehicle_registration_plate varchar references vehicles(registration_plate)
);

create table charging_sessions (
    id bigint auto_increment primary key,
    rfid_tag_number integer not null references rfid_tags(number),
    charge_point_unique_serial_number varchar not null,
    connector_number integer not null,
    time_start timestamp with time zone not null,
    meter_start integer not null,
    time_end timestamp with time zone,
    meter_end integer,
    error_message varchar,
    foreign key (charge_point_unique_serial_number, connector_number) references connectors(charge_point_unique_serial_number, number)
);