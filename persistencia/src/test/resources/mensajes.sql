insert into ciudad values (1, "Bogota");
insert into ciudad values (2, "Armenia");
insert into ciudad values (4, "Medellin");

INSERT INTO usuario VALUES (1231, "felipe1234", "felipe@email.com", "felipe", 1);
INSERT INTO usuario VALUES (1232, "maria1234", "maria@email.com", "maria", 2);
INSERT INTO usuario VALUES (1233, "juan1234", "juan@email.com", "juan", 4);

INSERT INTO chat VALUES (0001, 1231, 1232);
INSERT INTO chat VALUES (0002, 1232, 1233);
INSERT INTO chat VALUES (0003, 1231, 1233);

insert into mensaje values (2221, "Andres", DATE("2022/01/12"), "Hola, como se encuentra", 0001);
insert into mensaje values (2222, "Geronimo", DATE("2022/02/07"), "Ok, no hay problema", 0002);
insert into mensaje values (2223, "Miguel", DATE("2022/03/14"), "Pero, no tiene envío gratis?", 0003);