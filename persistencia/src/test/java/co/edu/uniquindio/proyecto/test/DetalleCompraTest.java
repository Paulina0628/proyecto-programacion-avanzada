package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Compra;
import co.edu.uniquindio.proyecto.Entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.Entidades.Producto;
import co.edu.uniquindio.proyecto.Repositorios.CompraRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.DetalleCompraRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleCompraTest {

    @Autowired
    private DetalleCompraRepositorio detalleRepositorio;

    @Autowired
    private CompraRepositorio compraRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Test
    @Sql("classpath:detallecompras.sql")
    public void registrarDetalleCompraTest() {

        //Buscamos el producto de detallecompra
        Producto producto = productoRepositorio.findById(123).orElse(null);

        //Buscamos la compra del detalle compra
        Compra compra = compraRepositorio.findById(5551).orElse(null);

        // Creamos el detalle compra a guardar
        DetalleCompra detalleCompra = new DetalleCompra(3334, producto, compra, 14, 14000);

        // Se guarda el detalle compra compra creado
        DetalleCompra detalleGuardado = detalleRepositorio.save(detalleCompra);

        // Validamos que se haya guardado el chat
        Assertions.assertNotNull(detalleGuardado);

    }

    @Test
    @Sql("classpath:detallecompras.sql")
    public void eliminarTest(){

        // Eliminamos el detalle compra por su id
        detalleRepositorio.deleteById(3331);

        // La buscamos para validar si la eliminación ha sido exitosa
        DetalleCompra detalleGuardado = detalleRepositorio.findById(3331).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(detalleGuardado);

    }

    @Test
    @Sql("classpath:detallecompras.sql")
    public void actualizarTest(){

        // Conseguimos el detalle compra que se desea actualizar
        DetalleCompra detalleGuardado = detalleRepositorio.findById(3332).orElse(null);

        // Actualizamos las unidades
        detalleGuardado.setUnidades(10);

        // Guardamos el detalle compra con los cambios realizados
        detalleRepositorio.save(detalleGuardado);

        // Buscamos el detalle compra para validar la modificación de las unidades
        DetalleCompra detalleBuscado = detalleRepositorio.findById(3332).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals(10, detalleBuscado.getUnidades());

    }

    @Test
    @Sql("classpath:detallecompras.sql")
    public void listar(){

        // Conseguimos todos los detalle compras
        List<DetalleCompra> detalles = detalleRepositorio.findAll();

        // Y se imprimen
        detalles.forEach(u -> System.out.println(u));
        System.out.println(detalles);

    }

}
