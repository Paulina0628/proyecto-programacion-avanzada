insert into ciudad values (1, "Bogota");
insert into ciudad values (2, "Armenia");
insert into ciudad values (4, "Medellin");

insert into usuario values (23145, "Alejandrita12", "Alejandra", "aleja@gmail.com", 1);
insert into usuario values (54321, "pepe213","Felipe", "pepito@gmail.com", 2);
insert into usuario values (45321, "Andresito123","Andres", "andres@gmail.com", 4);

insert into producto values (123, "Producto1", 2300, "2021/12/31", "Producto1", 25000, 20, 1, 23145);
insert into producto values (345, "Hola este es el producto3", 0, "2021/05/10", "Producto3", 7000, 10, 2, 54321);
insert into producto values (234, "Hola este es el producto2", 4000, "2021/07/14", "Producto2", 10000, 14, 4, 45321);

INSERT INTO subasta(codigo, fecha_limite, codigo_producto) VALUES (1111, "30/02/2022", 123);
INSERT INTO subasta(codigo, fecha_limite, codigo_producto) VALUES (2222, "30/02/2022", 345);
INSERT INTO subasta(codigo, fecha_limite, codigo_producto) VALUES (3333, "30/02/2022", 234);

INSERT INTO subasta_usuario VALUES (888, "2022/02/14", 25000, 2222, 54321);
INSERT INTO subasta_usuario VALUES (999, "2022/02/14", 25000, 1111, 23145);
