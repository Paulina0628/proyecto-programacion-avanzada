package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Administrador;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    @Test
    @Sql("classpath:administradores.sql")
    public void registrarAdministradorTest() {

        // Creamos el administrador a guardar
        Administrador administrador = new Administrador(4444, "Admin1", "admin123@gmail.com", "admin12345");

        // Se guarda el administrador creado
        Administrador administradorGuardado = administradorRepositorio.save(administrador);

        // Validamos que se haya guardado el administrador
        Assertions.assertNotNull(administradorGuardado);

    }

    @Test
    @Sql("classpath:administradores.sql")
    public void eliminarTest(){

        // Eliminamos el el administrador por su id
        administradorRepositorio.deleteById(4441);

        // La buscamos para validar si la eliminación ha sido exitosa
        Administrador administradorGuardado = administradorRepositorio.findById(1).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(administradorGuardado);

    }

    @Test
    @Sql("classpath:administradores.sql")
    public void actualizarTest(){

        // Conseguimos el administrador que se desea actualizar
        Administrador administradorGuardado = administradorRepositorio.findById(4442).orElse(null);

        // Actualizamos el email
        administradorGuardado.setEmail("adminsito@gmail.com");

        // Guardamos el administrador con los cambios realizados
        administradorRepositorio.save(administradorGuardado);

        // Buscamos el administrador para validar la modificación de su email
        Administrador administradorBuscado = administradorRepositorio.findById(4442).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals("adminsito@gmail.com", administradorBuscado.getEmail());

    }

    @Test
    @Sql("classpath:administradores.sql")
    public void listar(){

        // Conseguimos todos los administradores
        List<Administrador> administradores = administradorRepositorio.findAll();

        // Y se imprimen
        administradores.forEach(u -> System.out.println(u));
        System.out.println(administradores);

    }

}
