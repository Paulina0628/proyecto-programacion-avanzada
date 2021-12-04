package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Test
    @Sql("classpath:comentarios.sql")
    public void registrarComentarioTest() {

        //Buscamos el producto del comentario
        Producto producto = productoRepositorio.findById(123).orElse(null);

        // Creamos el comentario a guardar
        Comentario comentario = new Comentario(6664, producto, "Buenos dias, tiene stock?", "Buenos dias, si hay stock", "2021/11/30", 4.5) ;

        // Se guarda el comentario creado
        Comentario comentarioGuardado = comentarioRepositorio.save(comentario);

        // Validamos que se haya guardado el comentario
        Assertions.assertNotNull(comentarioGuardado);

    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void eliminarTest(){

        // Eliminamos el comentario por su id
        comentarioRepositorio.deleteById(6661);

        // Lo buscamos para validar si la eliminación ha sido exitosa
        Comentario comentarioGuardado = comentarioRepositorio.findById(6661).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(comentarioGuardado);

    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void actualizarTest(){

        // Conseguimos el comentario que se desea actualizar
        Comentario comentarioGuardado = comentarioRepositorio.findById(6662).orElse(null);

        // Actualizamos la calificación
        comentarioGuardado.setCalificacion(5.0);

        // Guardamos el comentario con los cambios realizados
        comentarioRepositorio.save(comentarioGuardado);

        // Buscamos el comentario para validar la modificación de su calificación
        Comentario comentarioBuscado = comentarioRepositorio.findById(6662).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals(comentarioBuscado.getCalificacion(), 5.0);

    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void listar(){
        // Conseguimos todos los comentarios
        List<Comentario> comentarios = comentarioRepositorio.findAll();
        Assertions.assertEquals(comentarios.size(), 3);
    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void listarPorCalificacionTest() {
        List<Comentario> lista = comentarioRepositorio.findAllByCalificacion(3.5);
        Assertions.assertEquals(lista.size(), 1);
    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void listarPorFechaTest() {
        List<Comentario> comentarios = comentarioRepositorio.findAllByFechaComentario("2021/09/10");
        Assertions.assertEquals(comentarios.size(), 1);
    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void listarProductoComentadoTest() {
        Producto producto = productoRepositorio.findById(123).orElse(null);
        Optional<Comentario> comentario = comentarioRepositorio.findByProductoComentado(producto);
        Assertions.assertTrue(comentario.isPresent());
    }

    @Test
    @Sql("classpath:comentarios.sql")
    public void listarPorRangoCalificacion(){

        List<Comentario> comentarios = comentarioRepositorio.listarComentariosEnRango(2.5,5.0);
        Assertions.assertEquals(comentarios.size(), 3);
    }
}
