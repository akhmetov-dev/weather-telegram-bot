create table Persons (
	id bigserial primary key,
	first_name char(20) not null,
	last_name char(20) not null
);

insert into persons (first_name, last_name) values ('Dmitry', 'Zabelov');
insert into persons (first_name, last_name) values ('Vasily', 'Fomenkov');
insert into persons (first_name, last_name) values ('Artyom', 'Sherstyuk');
insert into persons (first_name, last_name) values ('Kirill', 'Moskalyov');
insert into persons (first_name, last_name) values ('Anna', 'Zaharova');
insert into persons (first_name, last_name) values ('Vlasov', 'Dmitry');
insert into persons (first_name, last_name) values ('Demid', 'Uzenkov');
insert into persons (first_name, last_name) values ('David', 'Shagramanyan');
insert into persons (first_name, last_name) values ('Gleb', 'Kochevoy');
