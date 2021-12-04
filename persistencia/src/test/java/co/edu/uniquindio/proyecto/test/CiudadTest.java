package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepositorio;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    @Test
    @Sql("classpath:ciudades.sql")
    public void registrarCiudadTest() {

        // Creamos la ciudad a guardar
        Ciudad ciudad = new Ciudad(4, "Medellin");

        // Se guarda la ciudad creada
        Ciudad ciudadGuardada = ciudadRepositorio.save(ciudad);

        // Validamos que se haya guardado la ciudad
        Assertions.assertNotNull(ciudadGuardada);

    }

    @Test
    @Sql("classpath:ciudades.sql")
    public void eliminarTest(){

        // Eliminamos el producto por su id
        ciudadRepositorio.deleteById(1);

        // La buscamos para validar si la eliminación ha sido exitosa
        Ciudad ciudadGuardada = ciudadRepositorio.findById(1).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(ciudadGuardada);

    }

    @Test
    @Sql("classpath:ciudades.sql")
    public void actualizarTest(){

        // Conseguimos la ciudad que se desea actualizar
        Ciudad ciudadGuardada = ciudadRepositorio.findById(2).orElse(null);

        // Actualizamos el nombre
        ciudadGuardada.setNombre("Pereira");

        // Guardamos la ciudad con los cambios realizados
        ciudadRepositorio.save(ciudadGuardada);

        // Buscamos la ciudad para validar la modificación de su nombre
        Ciudad ciudadBuscada = ciudadRepositorio.findById(2).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals("Pereira", ciudadBuscada.getNombre());

    }

    @Test
    @Sql("classpath:ciudades.sql")
    public void listar(){

        // Conseguimos todas las ciudades
        List<Ciudad> ciudades = ciudadRepositorio.findAll();

        // Y se imprimen
        ciudades.forEach(u -> System.out.println(u));
        System.out.println(ciudades);

    }

    @Test
    @Sql("classpath:ciudades.sql")
    public void listarPorNombreTest() {
        List<Ciudad> lista = ciudadRepositorio.findAllByNombreContains("Armenia");
        lista.forEach(ciudad -> System.out.println(ciudad));

    }

}
