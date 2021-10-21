
# Creamos el producto

INSERT INTO producto(codigo, nombre, unidades, descripcion, precio, fecha_limite, descuento ) VALUES (10000, "producto1", 20, "hoaojsjsk", 25000, "30/02/2022", 2000);
INSERT INTO producto(codigo, nombre, unidades, descripcion, precio, fecha_limite, descuento ) VALUES (20000, "producto2", 20, "hoaojswesjsk", 25000, "30/02/2022", 2000);
INSERT INTO producto(codigo, nombre, unidades, descripcion, precio, fecha_limite, descuento ) VALUES (30000, "producto3", 20, "hoaojdsasjsk", 25000, "30/02/2022", 2000);

# Creamos la subasta
INSERT INTO subasta(codigo, fecha_limite, codigo_producto) VALUES (11111, "30/02/2022", 10000);
INSERT INTO subasta(codigo, fecha_limite, codigo_producto) VALUES (22222, "30/02/2022", 20000);
INSERT INTO subasta(codigo, fecha_limite, codigo_producto) VALUES (33333, "30/02/2022", 30000);