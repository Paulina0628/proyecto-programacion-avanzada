
# Se crean los usuarios
INSERT INTO usuario(nombre, email, contrasenia, codigo, telefonos) VALUES ("felipe", "felipe@email.com", "felipe1234", 123, INSERT INTO $usuario_telefonos(tipo, numero) VALUES ("casa", "312345"));
INSERT INTO usuario(nombre, email, contrasenia, codigo, telefonos) VALUES ("maria", "maria@email.com", "maria1234", 1232, INSERT INTO $usuario_telefonos(tipo, numero) VALUES ("celular", "2234665"));
INSERT INTO usuario(nombre, email, contrasenia, codigo, telefonos) VALUES ("juan", "juan@email.com", "juan1234", 1233, INSERT INTO $usuario_telefonos(tipo, numero) VALUES ("celular", "4356373"));

# Se crean las subastas
INSERT INTO subasta(codigo, fechaLimite, codigoProducto) VALUES(233, 04/20/22, 1234);
INSERT INTO subasta(codigo, fechaLimite, codigoProducto) VALUES(344, 04/25/22, 8965);
INSERT INTO subasta(codigo, fechaLimite, codigoProducto) VALUES(455, 04/29/22, 4567);

# Se crean las subastaUsuario
INSERT INTO subastaUsuario(codigo, codigoSubasta, codigoUsuario, valor) VALUES (100, 233, 123, 25000);
INSERT INTO subastaUsuario(codigo, codigoSubasta, codigoUsuario, valor) VALUES (200, 344, 1232, 55000);
INSERT INTO subastaUsuario(codigo, codigoSubasta, codigoUsuario, valor) VALUES (300, 455, 1233, 14000);