package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.*;
import co.edu.uniquindio.proyecto.Repositorios.SubastaRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.SubastaUsuarioRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubataUsuarioTest {

    @Autowired
    private SubastaRepositorio subastaRepositorio;

    @Autowired
    private SubastaUsuarioRepositorio subastaUsuarioRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    @Sql("classpath:subastaUsuario.sql")
    public void registrarSubastaUsuarioTest() {

        // Hallamos el usuario por su id
        Usuario usuario = usuarioRepositorio.findById(45321).orElse(null);

        // Hallamos la subasta por su id
        Subasta subasta = subastaRepositorio.findById(3333).orElse(null);

        // Creamos la subasta Usuario
        SubastaUsuario subastaUsuario = new SubastaUsuario(777, subasta, usuario, 40000, "2021/08/10");

        // Se guarda la subasta Usuario creada
        SubastaUsuario subastaUsuarioB = subastaUsuarioRepositorio.save(subastaUsuario);

        // Validamos que se haya guardado la subasta Usuario
        Assertions.assertNotNull(subastaUsuarioB);

    }

    @Test
    @Sql("classpath:subastaUsuario.sql")
    public void eliminarTest(){

        // Eliminamos la Subasta Usuario por su id
        subastaUsuarioRepositorio.deleteById(888);

        // Lo buscamos para validar si la eliminación ha sido exitosa
        SubastaUsuario subastaUsuarioB = subastaUsuarioRepositorio.findById(888).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(subastaUsuarioB);

    }

    @Test
    @Sql("classpath:subastaUsuario.sql")
    public void actualizarTest(){

        // Conseguimos la subasta que se desea actualzar
        SubastaUsuario subastaUsuarioGuardada = subastaUsuarioRepositorio.findById(999).orElse(null);

        // Actualizamos la fecha
        subastaUsuarioGuardada.setFechaSubasta("2022/04/12");

        // Guardamos la subasta Usuario con los cambios realizados
        subastaUsuarioRepositorio.save(subastaUsuarioGuardada);

        // Buscamos la subasta Usuario para validar la modificación de su información
        SubastaUsuario subastaUsuarioBuscado = subastaUsuarioRepositorio.findById(999).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals("2022/04/12", subastaUsuarioBuscado.getFechaSubasta());

    }

    @Test
    @Sql("classpath:subastaUsuario.sql")
    public void listar(){

        // Conseguimos todas las subastas Usuario
        List<SubastaUsuario> subastasUsuario = subastaUsuarioRepositorio.findAll();

        // Y se imprimen
        subastasUsuario.forEach(u -> System.out.println(u));
        System.out.println(subastasUsuario);

    }
}
