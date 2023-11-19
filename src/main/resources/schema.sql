create database clients;
use clients;

create table clients(
	id int primary key auto_increment,
    nombre varchar(75),
    apellido varchar(75),
    fecha_nacimiento date
);