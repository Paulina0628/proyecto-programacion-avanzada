package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Subasta;
import co.edu.uniquindio.proyecto.Entidades.SubastaUsuario;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepositorio;
import co.edu.uniquindio.proyecto.repositorios.SubastaUsuarioRepositorio;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepositorio;
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

    // Tienes que usar lo que declaraste no irte a UsuarioRepositorio
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    public void registrarSubastaUsuarioTest() {

        // Creación de los datos previos
        Subasta subasta = crearSubastaPrueba();
        Subasta subastaS = subastaRepositorio.save(subasta);
        Usuario usuario = crearUsuarioPrueba();
        Usuario usuarioS = usuarioRepositorio.save(usuario);


        // Validamos que se haya guardado la información
        Assertions.assertNotNull(usuarioS);
        Assertions.assertNotNull(subastaS);

        // Creamos la SubastaUsuario
        SubastaUsuario subastaUsuario = crearsubastaUsuarioPrueba(usuarioS, subastaS);

        // Guardamos el dato de la subastaUsuario
        SubastaUsuario resultado = subastaUsuarioRepositorio.save(subastaUsuario);

        // Validamos que se haya guardado la información
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void editarUsuario() {

        // Creación de los datos previos
        Subasta subasta = crearSubastaPrueba();
        Subasta subastaS = subastaRepositorio.save(subasta);
        Usuario usuario = crearUsuarioPrueba();
        Usuario usuarioS = usuarioRepositorio.save(usuario);


        // Validamos que se haya guardado la información
        Assertions.assertNotNull(usuarioS);
        Assertions.assertNotNull(subastaS);

        // Creamos la SubastaUsuario
        SubastaUsuario subastaUsuario = crearsubastaUsuarioPrueba(usuarioS, subastaS);
        int subastaUsuarioId = subastaUsuarioRepositorio.save(subastaUsuario).getCodigo();

        // Buscamos la subastaUsuario
        SubastaUsuario busqueda = subastaUsuarioRepositorio.findById(subastaUsuarioId).orElse(null);
        Assertions.assertNotNull(busqueda);

        // Modificamos datos
        busqueda.setFechaSubasta("15/11/2021");

        // Guardamos datos
        SubastaUsuario resultado = subastaUsuarioRepositorio.save(busqueda);
    }

    @Test
    public void eliminarUsuario() {

        // Creación de los datos previos
        Subasta subasta = crearSubastaPrueba();
        Subasta subastaS = subastaRepositorio.save(subasta);
        Usuario usuario = crearUsuarioPrueba();
        Usuario usuarioS = usuarioRepositorio.save(usuario);


        // Validamos que se haya guardado la información
        Assertions.assertNotNull(usuarioS);
        Assertions.assertNotNull(subastaS);

        // Creamos la SubastaUsuario
        SubastaUsuario subastaUsuario = crearsubastaUsuarioPrueba(usuarioS, subastaS);
        int subastaUsuarioId = subastaUsuarioRepositorio.save(subastaUsuario).getCodigo();

        // Buscamos el usuario
        SubastaUsuario busqueda = subastaUsuarioRepositorio.findById(subastaUsuarioId).orElse(null);
        Assertions.assertNotNull(busqueda);

        // Eliminemos el usuario
        subastaUsuarioRepositorio.delete(busqueda);

        // Guardamos datos
        SubastaUsuario busquedaNueva = subastaUsuarioRepositorio.findById(subastaUsuarioId).orElse(null);
        Assertions.assertNull(busquedaNueva);

    }

    @Test
    @Sql("classpath:subastaUsuario.sql")
    public void listarSubastaUsuariosTest() {
        List<SubastaUsuario> lista = subastaUsuarioRepositorio.findAll();
        System.out.println(lista);
    }

    private SubastaUsuario crearsubastaUsuarioPrueba(Usuario usuario, Subasta subasta) {

        SubastaUsuario subastaU = new SubastaUsuario();
        subastaU.setCodigo(111);
        subastaU.setValor(24000);
        subastaU.setFechaSubasta("08/10/2021");
        subastaU.setUsuarioSubasta(usuario);
        subastaU.setSubasta(subasta);

        return subastaU;

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

    private Subasta crearSubastaPrueba() {

        Subasta subasta = new Subasta();
        subasta.setCodigo(100);
        subasta.setFechaLimite("06/11/2021");

        return subasta;
    }
}
