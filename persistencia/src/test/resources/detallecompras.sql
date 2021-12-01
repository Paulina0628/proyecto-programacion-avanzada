insert into ciudad values (1, "Bogota");
insert into ciudad values (2, "Armenia");
insert into ciudad values (4, "Medellin");

insert into usuario values (23145, "Alejandrita12", "Alejandra", "aleja@gmail.com", 1);
insert into usuario values (54321, "pepe213","Felipe", "pepito@gmail.com", 2);
insert into usuario values (45321, "Andresito123","Andres", "andres@gmail.com", 4);

insert into producto values (123, "Producto1", 2300, "2021/12/31", "Producto1", 25000, 20, 1, 23145);
insert into producto values (345, "Hola este es el producto3", 0, "2021/05/10", "Producto3", 7000, 10, 2, 54321);
insert into producto values (234, "Hola este es el producto2", 4000, "2021/07/14", "Producto2", 10000, 14, 4, 45321);

insert into compra values (5551, "2021/05/10", "Tarjeta credito", 23145);
insert into compra values (5552, "2021/08/14", "Efectiva", 54321);
insert into compra values (5553, "2021/09/10", "Contra entrega`", 45321);

insert into detalle_compra values (3331, 4000, 10, 5551, 123);
insert into detalle_compra values (3332, 7000, 5, 5552, 345);
insert into detalle_compra values (3333, 6000, 4, 5553, 234);