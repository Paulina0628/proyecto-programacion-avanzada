package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Categoria;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Repositorios.CategoriaRepositorio;
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
public class CategoriaTest {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    @Sql("classpath:categorias.sql")
    public void registrarCategoriaTest() {

        // Creamos la categoria a guardar
        Categoria categoria = new Categoria(5554, "Anime");

        // Se guarda la categoria creada
        Categoria categoriaGuardada = categoriaRepositorio.save(categoria);

        // Validamos que se haya guardado la categoria
        Assertions.assertNotNull(categoriaGuardada);

    }

    @Test
    @Sql("classpath:categorias.sql")
    public void eliminarTest(){

        // Eliminamos la categoria por su id
        categoriaRepositorio.deleteById(5551);

        // La buscamos para validar si la eliminación ha sido exitosa
        Categoria categoriaGuardada = categoriaRepositorio.findById(5551).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(categoriaGuardada);

    }

    @Test
    @Sql("classpath:categorias.sql")
    public void actualizarTest(){

        // Conseguimos la categoria que se desea actualizar
        Categoria categoriaGuardada = categoriaRepositorio.findById(5552).orElse(null);

        // Actualizamos el nombre
        categoriaGuardada.setNombre("Comedia");

        // Guardamos la categoria con los cambios realizados
        categoriaRepositorio.save(categoriaGuardada);

        // Buscamos la categoria para validar la modificación de su nombre
        Categoria categoriaBuscada = categoriaRepositorio.findById(5552).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals("Comedia", categoriaBuscada.getNombre());

    }

    @Test
    @Sql("classpath:categorias.sql")
    public void listar(){

        // Conseguimos todas las categorias
        List<Categoria> categorias = categoriaRepositorio.findAll();

        // Y se imprimen
        categorias.forEach(u -> System.out.println(u));
        System.out.println(categorias);

    }
}
