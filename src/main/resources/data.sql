DROP TABLE IF EXISTS persona;

create table persona(
	id int auto_increment,
	name varchar(250),
	last_name varchar(250),
	address varchar(250),
	simple_phone_number integer,
	hair_colour varchar(250)
);

insert into persona(name, last_name, address, simple_phone_number, hair_colour) values ('Leandro', 'Hernandez', 'Av Americo Vespucio', 569346289, 'black');