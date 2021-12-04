package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepositorio;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarPorNombreTest() {
        List<Usuario> lista = usuarioRepositorio.findAllByNombreContains("maria");
        Assertions.assertEquals(lista.size(), 1);

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarPorEmailTest() {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail("maria@email.com");
        Assertions.assertTrue(usuario.isPresent());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarPorEmailAndContraseniaTest() {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmailAndContrasenia("felipe@email.com", "felipe1234");
        Assertions.assertTrue(usuario.isPresent());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void paginarListaTest() {

        Pageable paginador = PageRequest.of(0,2);

        Page<Usuario> lista = usuarioRepositorio.findAll(paginador);
        System.out.println(lista.stream().collect(Collectors.toList()));

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ordenarListaTest() {


        List<Usuario> lista = usuarioRepositorio.findAll(Sort.by("nombre"));
        System.out.println(lista.stream().collect(Collectors.toList()));

    }

}
