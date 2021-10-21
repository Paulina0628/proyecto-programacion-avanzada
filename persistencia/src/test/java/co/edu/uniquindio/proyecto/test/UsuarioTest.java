package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
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

    @Test
    public void registrarUsuarioTest() {

        // Creamos el usuario
        Usuario usuario = crearUsuarioPrueba();

        // Guardamos el dato del usuario
        Usuario resultado = usuarioRepositorio.save(usuario);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void editarUsuarioTest() {

        // Creamos el usuario
        Usuario usuario = crearUsuarioPrueba();
        int usuarioId = usuarioRepositorio.save(usuario).getCodigo();

        // Buscamos el usuario
        Usuario usuarioBuscado = usuarioRepositorio.findById(usuarioId).orElse(null);
        Assertions.assertNotNull(usuarioBuscado);

        // Modificamos datos
        usuarioBuscado.setEmail("pepito2000@email.com");

        // Guardamos datos
        Usuario usuarioEditado = usuarioRepositorio.save(usuarioBuscado);

        // Validamos datos
        Assertions.assertNotNull(usuarioEditado);

    }

    @Test
    public void eliminarUsuario() {

        // Creamos el usuario
        Usuario usuario = crearUsuarioPrueba();
        int usuarioId = usuarioRepositorio.save(usuario).getCodigo();

        // Buscamos el usuario
        Usuario usuarioBuscado = usuarioRepositorio.findById(usuarioId).orElse(null);
        Assertions.assertNotNull(usuarioBuscado);

        // Eliminamos el usuario
        usuarioRepositorio.delete(usuarioBuscado);

        // Verificamos datos
        Usuario busquedaNueva = usuarioRepositorio.findById(usuarioId).orElse(null);
        Assertions.assertNull(busquedaNueva);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTest() {
        List<Usuario> lista = usuarioRepositorio.findAll();
        System.out.println(lista);
    }


        private Usuario crearUsuarioPrueba() {
        Usuario usuario = new Usuario();
        usuario.setCodigo(1234);
        usuario.setNombre("Pepito");
        usuario.setEmail("pepito@email.com");
        usuario.setContrasenia("pepito1234");

        Map<String, String> usuario_telefono = new HashMap<>();
        usuario_telefono.put("Casa", "311353");
        usuario_telefono.put("Celular", "312034");
        usuario.setTelefonos(usuario_telefono);

        return usuario;
    }
}
