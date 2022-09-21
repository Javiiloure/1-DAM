drop database if exists floristeria;
create database floristeria;
use floristeria;

# Creacion de tablas

create table articulo (
	codigo_articulo int auto_increment primary key,
	stock int not null
		check (stock >= 0),
	precio decimal(10, 2) not null
		check (precio > 0)
);

create table planta (
	codigo_planta int,
	foreign key (codigo_planta)
		references articulo(codigo_articulo)
			on delete cascade
			on update cascade,
	primary key(codigo_planta),
	nombre_planta varchar(50) not null,
	nombre_cientifico varchar(100) not null,
	flor bool not null,
	caracteristicas_regadio varchar(100) not null
);

create table maceta (
	codigo_maceta int,
	foreign key (codigo_maceta)
		references articulo(codigo_articulo)
			on delete cascade
			on update cascade,
	primary key (codigo_maceta),
	alto_cm int not null,
		check(alto_cm > 0),
	diametro_cm int not null
		check(diametro_cm > 0),
	color enum('Blanco', 'Negro', 'Gris', 'Verde', 'Rojo', 'Azul', 'Marron', 'Amarillo', 'Violeta', 'Naranja'),
	material enum('Plastico', 'Arcilla', 'Piedra', 'Madera', 'Cemento', 'Fibrocemento'),
	exterior bool not null
);

create table ticket(
	codigo_ticket int auto_increment primary key,
	fecha_hora timestamp not null
);

create table ticket_articulo(
	ticket int,
	articulo int,
	unidades int not null
		check(unidades > 0),
	foreign key (ticket)
		references ticket(codigo_ticket)
			on delete cascade
			on update cascade,
	foreign key (articulo)
		references articulo(codigo_articulo)
			on delete cascade
			on update cascade,
	primary key(ticket, articulo)
);

# Inserccion de datos de prueba

insert into articulo (codigo_articulo, stock, precio)
values (1, 20, 14.99),
(2, 25, 12.99),
(3, 15, 39.99),
(4, 12, 30.00),
(5, 5, 59.99),
(6, 17, 10.99),
(7, 30, 7.99),
(8, 10, 25.99),
(9, 35, 5.99),
(10, 15, 25.99),
(11, 50, 5.99),
(12, 40, 7.99),
(13, 20, 12.99),
(14, 35, 9.99),
(15, 10, 25.99),
(16, 15, 19.99),
(17, 30, 8.99),
(18, 20, 9.99),
(19, 25, 39.99),
(20, 10, 35.99);

insert into planta (codigo_planta, nombre_planta, nombre_cientifico, flor, caracteristicas_regadio)
values (1, 'Lavanda', 'Lavandula', false, 'Regar 1 ó 2 veces por semana, sin mojar las ramas y las flores.'),
(2, 'Lirio', 'Lilium', true, 'Aportar riegos frecuentes pero no demasiado abundantes, entre cada 24 y 48 horas.'),
(3, 'Aloe Vera', 'Aloe', false, 'Regar cada 15 o 20 días, utilizando poca agua y vertiéndola directamente sobre la tierra.'),
(4, 'Tronco de Brasil', 'Dracaena Fragans', false, 'Regar un par de veces por semana en verano, y entre una vez por semana y 12 días en invierno.'),
(5, 'Higuera', 'Ficus caria', false, 'El riego deberá ser constante y de poca cantidad, evitando siempre los encharcamientos.'),
(6, 'Glicina', 'Wisteria', true, 'Necesita un riego regular y poco abundante.'),
(7, 'Campanilla', 'Campandula', true, 'Basta con mantener la tierra humeda'),
(8, 'Crotón', 'Codiaeum Variegatum', false, 'Riego abundante cada 3-4 días en verano y semanal en invierno'),
(9, 'Cactus chin', 'Gymnocalycium', false, 'Regar moderadamente una vez por semana'),
(10, 'Boca de dragon', 'Antirrhinum majus', true, 'El riego debe ser moderado, aumentando en los meses de verano, sin encharcarlo.');

insert into maceta (codigo_maceta, alto_cm, diametro_cm, color, material, exterior)
values (11, 10, 7, 'Negro', 'Plastico', false),
(12, 12, 9, 'Marron', 'Arcilla', true),
(13, 60, 50, 'Blanco', 'Madera', false),
(14, 10, 7, 'Blanco', 'Plastico', false),
(15, 70, 55, 'Gris', 'Cemento', true),
(16, 50, 40, 'Naranja', 'Piedra', true),
(17, 30, 15, 'Violeta', 'Plastico', true),
(18, 20, 12, 'Amarillo', 'Fibrocemento', true),
(19, 50, 45, 'Azul', 'Arcilla', true),
(20, 45, 30, 'Rojo', 'Fibrocemento', true);

insert into ticket (fecha_hora)
values ('2022-06-01 16:25:27'),
('2022-06-02 17:30:48'),
('2022-06-03 18:59:14'),
('2022-06-04 10:21:24'),
('2022-06-05 12:47:32'),
('2022-06-05 14:51:20'),
('2022-06-06 16:14:45');

insert into ticket_articulo (ticket, articulo, unidades)
values (1, 5, 4),
(1, 12, 5),
(1, 4, 2),
(2, 15, 1),
(2, 7, 4),
(3, 16, 2),
(3, 14, 1),
(3, 2, 3),
(4, 19, 5),
(5, 7, 2),
(5, 14, 2),
(6, 8, 1),
(6, 2, 3),
(6, 11, 4),
(7, 17, 2),
(7, 9, 2);

# Trigger para evitar ventas si no hay stock

delimiter //
drop trigger if exists no_hay_stock //
create trigger no_hay_stock
after insert on ticket_articulo
for each row
begin
	declare stock_actual int;
	declare unidades_ticket int;
	select stock into stock_actual from articulo a where a.codigo_articulo = (select articulo from ticket_articulo ta where ta.ticket = new.ticket);
	set unidades_ticket = new.unidades;
	if stock_actual < unidades_ticket then 
		delete from ticket where codigo_ticket = new.ticket;
		delete from ticket_articulo ta3 where ta3.ticket = new.ticket;
	end if;
end;
//
delimiter ;


 #insert into ticket (fecha_hora)
 #values('2022-06-06 10:13:27');

 
#insert into ticket_articulo (ticket, articulo, unidades)
#values(8, 5, 500);

# Trigger para reduccir el stock en caso de venta

delimiter //
drop trigger if exists venta //
create trigger venta
after insert on ticket_articulo
for each row
begin
	declare stock_actual int;
	declare stock_final int;
	select stock into stock_actual from articulo a where a.codigo_articulo = new.articulo;
	set stock_final = stock_actual - new.unidades;
	update articulo
		set stock = stock_final where codigo_articulo = new.articulo;
end;
//
delimiter ;
 
# insert into ticket (fecha_hora)      
# values('2022-06-06 10:13:27');                     

# insert into ticket_articulo (ticket, articulo, unidades)
# values(8, 5, 1);


# Trigger para aumentar stock en caso de devolución

delimiter //
drop trigger if exists devolucion //
create trigger devolucion 
after delete on ticket_articulo
for each row
begin
	declare stock_actual int;
	declare unidades_ticket int; 
	declare stock_final int;
	select stock into stock_actual from articulo a where a.codigo_articulo = old.articulo;
	set unidades_ticket = old.unidades;
	set stock_final = stock_actual + unidades_ticket;
	update articulo
		set stock = stock_final where codigo_articulo = old.articulo;
end;
//
delimiter ;

# delete from ticket_articulo where ticket = 2;
# delete from ticket where codigo_ticket = 2;

# Vista para el dependiente de los articulos disponibles

drop view if exists articulos_disponibles;
create view articulos_disponibles as
select codigo_articulo, stock from articulo a where a.stock > 0;

#insert into articulo (stock, precio)
#values(0, 20.00);

#insert into planta(codigo_planta, nombre_planta, nombre_cientifico, flor, caracteristicas_regadio)
#values(21, 'Marihuana', 'Cannabis sativa', false, 'Por regla general, se recomienda regar con un cuarto del volumen de tu maceta.');

# Vista para el administrador resumen de los tickets

drop view if exists resumen_tickets;
create view resumen_tickets as
select t.codigo_ticket, t.fecha_hora, ta.articulo, ta.unidades from ticket t
join ticket_articulo ta on t.codigo_ticket = ta.ticket order by t.fecha_hora desc;

# Vista para el administrador de los articulos mas vendidos

drop view if exists articulos_mas_vendidos;
create view articulos_mas_vendidos as
select ta.articulo, (select sum(ta.unidades) from ticket_articulo ta where ta.articulo = a.codigo_articulo) as unidades_totales from articulo a join ticket_articulo ta
on a.codigo_articulo = ta.articulo order by unidades desc limit 5;