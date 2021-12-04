package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Mensaje;
import co.edu.uniquindio.proyecto.repositorios.ChatRepositorio;
import co.edu.uniquindio.proyecto.repositorios.MensajeRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MensajeTest {

    @Autowired
    private ChatRepositorio chatRepositorio;

    @Autowired
    private MensajeRepositorio mensajeRepositorio;

    @Test
    @Sql("classpath:mensajes.sql")
    public void registrarCiudadTest() {

        //Buscamos el chat del mensaje
        Chat chat = chatRepositorio.findById(0001).orElse(null);

        // Creamos el mensaje a guardar
        Mensaje mensaje = new Mensaje(2224, chat, "Buenos dias", "Daniel", "2021/10/22");

        // Se guarda el mensaje creado
        Mensaje mensajeGuardado = mensajeRepositorio.save(mensaje);

        // Validamos que se haya guardado el chat
        Assertions.assertNotNull(mensajeGuardado);

    }

    @Test
    @Sql("classpath:mensajes.sql")
    public void eliminarTest(){

        // Eliminamos el mensaje por su id
        mensajeRepositorio.deleteById(2221);

        // Lo buscamos para validar si la eliminación ha sido exitosa
        Mensaje mensajeGuardado = mensajeRepositorio.findById(2221).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(mensajeGuardado);

    }

    @Test
    @Sql("classpath:mensajes.sql")
    public void actualizarTest(){

        // Conseguimos el mensaje que se desea actualizar
        Mensaje mensajeGuardado = mensajeRepositorio.findById(2222).orElse(null);

        // Actualizamos el mensaje
        mensajeGuardado.setMensaje("Buenos dias, cómo se encuentra?");

        // Guardamos el mensaje con los cambios realizados
        mensajeRepositorio.save(mensajeGuardado);

        // Buscamos el mensaje para validar la modificación de el mensaje
        Mensaje mensajeBuscado = mensajeRepositorio.findById(2222).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals("Buenos dias, cómo se encuentra?", mensajeBuscado.getMensaje());

    }

    @Test
    @Sql("classpath:mensajes.sql")
    public void listar(){

        // Conseguimos todos los mensajes
        List<Mensaje> mensajes = mensajeRepositorio.findAll();

        // Y se imprimen
        mensajes.forEach(u -> System.out.println(u));
        System.out.println(mensajes);

    }

    @Test
    @Sql("classpath:mensajes.sql")
    public void listarPorChat() {

        //Buscamos el chat del mensaje
        Chat chat = chatRepositorio.findById(0001).orElse(null);

        List<Mensaje> lista = mensajeRepositorio.findAllByChat(chat);
        Assertions.assertEquals(lista.size(), 1);

    }

    @Test
    @Sql("classpath:mensajes.sql")
    public void listarPorEmisor() {



        List<Mensaje> lista = mensajeRepositorio.findAllByEmisor("Andres");
        Assertions.assertEquals(lista.size(), 1);

    }
}
