package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Producto;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

        @Autowired
        private ProductoRepositorio productoRepositorio;

        @Autowired
        private CiudadRepositorio ciudadRepositorio;

        @Autowired
        private UsuarioRepositorio usuarioRepositorio;

        @Test
        @Sql("classpath:productos.sql")
        public void registrarProductoTest() {

            // Hallamos la ciudad por su id
            Ciudad ciudad = ciudadRepositorio.findById(4).orElse(null);

            // Hallamos el vendedor por su id
            Usuario vendedor = usuarioRepositorio.findById(45321).orElse(null);

            // Creamos el producto a guardar
            Producto producto = new Producto(ciudad, vendedor, 456, "Producto4", 14, "Este es el producto4", 4000, 18000, "2021/02/07");

            // Se guarda el producto creado
            Producto productoP = productoRepositorio.save(producto);

            // Validamos que se haya guardado el producto
            Assertions.assertNotNull(productoP);

        }

        @Test
        @Sql("classpath:productos.sql")
        public void eliminarTest(){

            // Eliminamos el producto por su id
            productoRepositorio.deleteById(123);

            // Lo buscamos para validar si la eliminación ha sido exitosa
            Producto productoBuscado = productoRepositorio.findById(123).orElse(null);

            // Validamos si se ha eliminado
            Assertions.assertNull(productoBuscado);

        }

        @Test
        @Sql("classpath:productos.sql")
        public void actualizarTest(){

            // Conseguimos el producto que se desea actualzar
            Producto productoGuardado = productoRepositorio.findById(345).orElse(null);

            // Actualizamos la descripción
            productoGuardado.setDescripcion("Nueva descripcion");

            // Guardamos el producto con los cambios realizados
            productoRepositorio.save(productoGuardado);

            // Buscamos el producto para validar la modificación de su información
            Producto productoBuscado = productoRepositorio.findById(345).orElse(null);

            // Validamos el cambio realizado
            Assertions.assertEquals("Nueva descripcion", productoBuscado.getDescripcion());

        }

        @Test
        @Sql("classpath:productos.sql")
        public void listar(){

            // Conseguimos todos los productos
            List<Producto> productos = productoRepositorio.findAll();

            // Y se imprimen
            productos.forEach(u -> System.out.println(u));
            System.out.println(productos);

        }


    }
