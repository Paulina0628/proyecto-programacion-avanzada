package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Producto;
import co.edu.uniquindio.proyecto.Entidades.Subasta;
import co.edu.uniquindio.proyecto.Entidades.SubastaUsuario;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepositorio;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

public class SubastaTest {


    @Autowired
    private SubastaRepositorio subastaRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Test
    public void registrarSubastaTest() {

        // Creación de los datos previos
        Producto producto = crearProductoPrueba();
        Producto productoP = productoRepositorio.save(producto);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(productoP);

        // Creamos la Subasta
        Subasta subasta = crearSubastaPrueba(productoP);

        // Guardamos el dato de la subasta
        Subasta resultado = subastaRepositorio.save(subasta);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void editarSubastaTest() {

        // Creación de los datos previos
        Producto producto = crearProductoPrueba();
        Producto productoP = productoRepositorio.save(producto);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(productoP);

        // Creamos la Subasta
        Subasta subasta = crearSubastaPrueba(productoP);
        int subastaId = subastaRepositorio.save(subasta).getCodigo();

        // Buscamos la subastaUsuario
        Subasta busqueda = subastaRepositorio.findById(subastaId).orElse(null);
        Assertions.assertNotNull(busqueda);

        // Modificamos datos
        busqueda.setFechaLimite("25/01/22");

        // Guardamos datos
        Subasta resultado = subastaRepositorio.save(busqueda);

    }

    @Test
    public void eliminarUsuario() {

        // Creación de los datos previos
        Producto producto = crearProductoPrueba();
        Producto productoP = productoRepositorio.save(producto);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(productoP);

        // Creamos la Subasta
        Subasta subasta = crearSubastaPrueba(productoP);
        int subastaId = subastaRepositorio.save(subasta).getCodigo();

        // Buscamos la subastaUsuario
        Subasta busqueda = subastaRepositorio.findById(subastaId).orElse(null);
        Assertions.assertNotNull(busqueda);

        // Eliminemos el usuario
        subastaRepositorio.delete(busqueda);

        // Guardamos datos
        Subasta busquedaNueva = subastaRepositorio.findById(subastaId).orElse(null);
        Assertions.assertNull(busquedaNueva);

    }

    @Test
    @Sql("classpath:subasta.sql")
    public void listarSubastaTest() {
        List<Subasta> lista = subastaRepositorio.findAll();
        System.out.println(lista);
    }

    private Subasta crearSubastaPrueba(Producto producto) {

        Subasta subasta = new Subasta("02/01/2022");
        subasta.setProductoSubasta(producto);

        return subasta;
    }

    private Producto crearProductoPrueba() {

        Producto producto = new Producto();
        producto.setCodigo(10000);
        producto.setNombre("producto1");
        producto.setUnidades(20);
        producto.setDescripcion("holaholahola");
        producto.setPrecio(25000);
        producto.setFechaLimite("31/12/2021");
        producto.setDescuento(2300);

        return producto;
    }

}
