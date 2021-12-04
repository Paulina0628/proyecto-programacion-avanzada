insert into ciudad values (1, "Bogota");
insert into ciudad values (2, "Armenia");
insert into ciudad values (4, "Medellin");

INSERT INTO usuario VALUES (1231, "felipe1234", "felipe@email.com", "felipe", 1);
INSERT INTO usuario VALUES (1232, "maria1234", "maria@email.com", "maria", 2);
INSERT INTO usuario VALUES (1233, "juan1234", "juan@email.com", "juan", 4);

insert into usuario_telefonos values (1231, "123123123", "Casa");
insert into usuario_telefonos values (1232, "123123123", "Trabajo");

insert into producto values (123, "Producto1", 2300, DATE("2021/12/31"), "Producto1", 25000, 20, 1, 1231);
insert into producto values (345, "Hola este es el producto3", 0, DATE("2021/05/10"), "Producto3", 7000, 10, 2, 1232);
insert into producto values (234, "Hola este es el producto2", 4000, DATE("2021/07/14"), "Producto2", 10000, 14, 4, 1233);

insert into favorito values (1231, 123);
insert into favorito values (1231, 345);
insert into favorito values (1232, 345);

insert into comentario values (6661, 3.5, DATE("2021/09/10"), "Buenos días, tiene descuento por el día sin IVA?", "Buenos tardes, no cuenta con descuento", 123, 123);
insert into comentario values (6662, 4.0, DATE("2021/11/30"), "Buenos días, de que tamaño es?", "Buenos días, 24 centímetros", 345, 345);
insert into comentario values (6663, 3.0, DATE("2021/10/20"), "Buenos tardes, qué colores tiene disponible?", "Buenos días, solo en rojo", 234, 234);



