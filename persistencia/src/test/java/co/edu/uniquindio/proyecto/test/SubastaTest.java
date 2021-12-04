package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepositorio;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubastaTest {


    @Autowired
    private SubastaRepositorio subastaRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Test
    @Sql("classpath:subasta.sql")
    public void registrarSubastaTest() {

        //Hallamos el producto
        Producto productoSubasta = productoRepositorio.findById(345).orElse(null);

        // Creamos la Subasta
        Subasta subasta = new Subasta(9876, productoSubasta, "2021/04/23");

        // Guardamos el dato de la subasta
        Subasta resultado = subastaRepositorio.save(subasta);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(resultado);

    }

    @Test
    @Sql("classpath:subasta.sql")
    public void eliminarSubastaTest() {

        // Borramos la subasta por su id
        subastaRepositorio.deleteById(1111);

        // Buscamos para confirmar si se ha eliminado
        Subasta subasta = subastaRepositorio.findById(1111).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(subasta);

    }

    @Test
    @Sql("classpath:subasta.sql")
    public void actualizarSubastaTest(){

        // Conseguimos la subasta guardada para actualzar
        Subasta subastaGuardada = subastaRepositorio.findById(2222).orElse(null);

        // Actualizamos la fecha limite
        subastaGuardada.setFechaLimite("2021/11/12");

        // Guardamos los cambios
        subastaRepositorio.save(subastaGuardada);

        // Buscamos la subasta para validar los cambios
        Subasta subastaBuscada = subastaRepositorio.findById(2222).orElse(null);

        // Validamos los cambios
        Assertions.assertEquals("2021/11/12", subastaBuscada.getFechaLimite());

    }

    @Test
    @Sql("classpath:subasta.sql")
    public void listarSubastaTest() {

        // Conseguimos todas las subastas
        List<Subasta> lista = subastaRepositorio.findAll();

        // Y se imprimen
        lista.forEach(u -> System.out.println(u));
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:subasta.sql")
    public void listarPorFechaLimite() {

        List<Subasta> lista = subastaRepositorio.findAllByFechaLimite("30/02/2022");
        Assertions.assertEquals(lista.size(), 1);

    }

    @Test
    @Sql("classpath:subasta.sql")
    public void listarPorProducto() {

        //Hallamos el producto
        Producto productoSubasta = productoRepositorio.findById(345).orElse(null);

        List<Subasta> lista = subastaRepositorio.findAllByProductoSubasta(productoSubasta);
        Assertions.assertEquals(lista.size(), 1);

    }


}
