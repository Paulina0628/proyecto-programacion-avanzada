package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Chat;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Producto;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.ChatRepositorio;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChatTest {

    @Autowired
    private ChatRepositorio chatRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    @Sql("classpath:chats.sql")
    public void registrarCiudadTest() {

        //Buscamos el usuario cliente
        Usuario usuarioCliente = usuarioRepositorio.findById(1231).orElse(null);

        // Ahora, buscamos el usuario vendedor
        Usuario usuarioVendedor = usuarioRepositorio.findById(1232).orElse(null);

        // Creamos el chat a guardar
        Chat chat = new Chat(0004, usuarioCliente, usuarioVendedor);

        // Se guarda el chat creado
        Chat chatGuardado = chatRepositorio.save(chat);

        // Validamos que se haya guardado el chat
        Assertions.assertNotNull(chatGuardado);

    }

    @Test
    @Sql("classpath:chats.sql")
    public void eliminarTest(){

        // Eliminamos el producto por su id
        chatRepositorio.deleteById(0001);

        // La buscamos para validar si la eliminación ha sido exitosa
        Chat chatGuardado = chatRepositorio.findById(0001).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(chatGuardado);

    }

    @Test
    @Sql("classpath:chats.sql")
    public void actualizarTest(){

        // Conseguimos la ciudad que se desea actualizar
        Chat chatGuardado = chatRepositorio.findById(0002).orElse(null);

        // Actualizamos el codigo
        chatGuardado.setCodigo(0005);

        // Guardamos el chat con los cambios realizados
        chatRepositorio.save(chatGuardado);

        // Buscamos el chat para validar la modificación de su codigo
        Chat chatBuscado = chatRepositorio.findById(0002).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals(0005, chatBuscado.getCodigo());

    }

    @Test
    @Sql("classpath:chats.sql")
    public void listar(){

        // Conseguimos todas los chats
        List<Chat> chats = chatRepositorio.findAll();

        // Y se imprimen
        chats.forEach(u -> System.out.println(u));
        System.out.println(chats);

    }

}
