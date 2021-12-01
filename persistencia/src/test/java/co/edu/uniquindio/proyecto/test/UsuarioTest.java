package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepositorio;
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
public class UsuarioTest {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarUsuarioTest() {

        // Hallamos la ciudad
        Ciudad ciudad = ciudadRepositorio.findById(1).orElse(null);

        // Creamos el hash map de telefonos
        Map<String, String> telefonos = new HashMap<>();

        // Le insertamos valores al hash map
        telefonos.put("casa", "123123");
        telefonos.put("celular", "3112322334");

        // Creamos el nuevo usuario
        Usuario usuario = new Usuario(1234, "Dahiana", "dahiana@gmail.com", "dahianita123", ciudad, telefonos);

        // Guardamos el usuario creado
        Usuario usuarioGuardado = usuarioRepositorio.save(usuario);

        // Validamos que se haya guardado con exito el usuario creado
        Assertions.assertNotNull(usuarioGuardado);

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void eliminar(){

        // Borramos el usuario por su id
        usuarioRepositorio.deleteById(1231);

        // Buscamos el usuario para validar si se ha eliminado
        Usuario usuarioBuscado = usuarioRepositorio.findById(1231).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(usuarioBuscado);

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void actualizar(){

        // Buscamos el usuario guardado que se desea modificar
        Usuario usuarioGuardado = usuarioRepositorio.findById(1232).orElse(null);

        // Le cambiamos el email
        usuarioGuardado.setEmail("maria123@gmail.com");

        // Guardamos el usuario con los cambios hechos
        usuarioRepositorio.save(usuarioGuardado);

        // Ahora, buscamos el usuario para validar el cambio correcto del email
        Usuario usuarioBuscado = usuarioRepositorio.findById(1232).orElse(null);

        // Validamos que se haya hecho correctamente el cambio
        Assertions.assertEquals("maria123@gmail.com", usuarioBuscado.getEmail());

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTest() {

        // Conseguimos todos los usuarios
        List<Usuario> usuarios = usuarioRepositorio.findAll();

        // y los imprimimos
        usuarios.forEach(u -> System.out.println(u));
        System.out.println(usuarios);
    }

}
