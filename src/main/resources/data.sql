insert into curso (nombre) values ('1A');
insert into curso (nombre) values ('1B');
insert into curso (nombre) values ('2A');
insert into curso (nombre) values ('2B');
insert into curso (nombre) values ('3A');
insert into curso (nombre) values ('3B');

insert into plan (nombre) values ('P2023-2024-1A');
insert into plan (nombre) values ('P2023-2024-1B');
insert into plan (nombre) values ('P2023-2024-2A');
insert into plan (nombre) values ('P2023-2024-2B');

insert into plan (nombre, FK_CURSO) values ('P2023-2024-3A','1A');
insert into plan (nombre, FK_CURSO) values ('P2023-2024-3B','1B');

insert into tutor (nombre, email) values ('Marcos','marcos@educastur.org');
insert into tutor (nombre, email) values ('Javier','javier@educastur.org');
insert into tutor (nombre, email, plan) values ('Maria','maria@educastur.org',3);
insert into tutor (nombre, email, plan) values ('Marta','marta@educastur.org',4);
insert into tutor (nombre, email, plan) values ('Pedro','pedro@educastur.org',5);
insert into tutor (nombre, email, plan) values ('Lucia','lucia@educastur.org',6);


insert into actividad(obligatoria, nombre, descripcion) values(0, 'actividad1', 'descripcion...');
insert into actividad(obligatoria, nombre, descripcion) values(0, 'actividad2', 'descripcion...');
insert into actividad(obligatoria, nombre, descripcion) values(0, 'actividad3', 'descripcion...');
insert into actividad(obligatoria, nombre, descripcion) values(0, 'actividad4', 'descripcion...');
insert into actividad(obligatoria, nombre, descripcion) values(0, 'actividad5', 'descripcion...');
insert into actividad(obligatoria, nombre, descripcion) values(0, 'actividad6', 'descripcion...');

insert into enmarca(plan_id, actividad_id) values(1, 1);
insert into enmarca(plan_id, actividad_id) values(2, 2);
insert into enmarca(plan_id, actividad_id) values(3, 3);
insert into enmarca(plan_id, actividad_id) values(4, 4);
insert into enmarca(plan_id, actividad_id) values(5, 5);

insert into usuario(nombre, password) values('pelayo', '$2a$12$pyfNrA8fDrJX1xyXJAz.FOvpYpymdrNtO946dUFlQE71sKhom.iQO');
insert into usuario(nombre, password) values('pedro', '$2a$12$FKYimulRZzDqm.L9IzuIMeRzKkWq.Pb7zOvdWr1FljEA1dC6lC3T2');