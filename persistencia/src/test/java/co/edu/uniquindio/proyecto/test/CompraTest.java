package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Entidades.Compra;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.CompraRepositorio;
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
public class CompraTest {

    @Autowired
    private CompraRepositorio compraRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    @Sql("classpath:compras.sql")
    public void registrarCompraTest() {

        //Buscamos el usuario de la compra
        Usuario usuario = usuarioRepositorio.findById(23145).orElse(null);

        // Creamos la compra a guardar
        Compra compra = new Compra(5554, usuario, "2021/07/07", "Tarjeta de credito");

        // Se guarda la compra creado
        Compra compraGuardada = compraRepositorio.save(compra);

        // Validamos que se haya guardado el chat
        Assertions.assertNotNull(compraGuardada);

    }

    @Test
    @Sql("classpath:compras.sql")
    public void eliminarTest(){

        // Eliminamos la compra por su id
        compraRepositorio.deleteById(5551);

        // La buscamos para validar si la eliminación ha sido exitosa
        Compra compraGuardada = compraRepositorio.findById(5551).orElse(null);

        // Validamos si se ha eliminado
        Assertions.assertNull(compraGuardada);

    }

    @Test
    @Sql("classpath:compras.sql")
    public void actualizarTest(){

        // Conseguimos la compra que se desea actualizar
        Compra compraGuardada = compraRepositorio.findById(5552).orElse(null);

        // Actualizamos el método de pago
        compraGuardada.setMetodoPago("Efectivo");

        // Guardamos la compra con los cambios realizados
        compraRepositorio.save(compraGuardada);

        // Buscamos la compra para validar la modificación de su método de pago
        Compra compraBuscada = compraRepositorio.findById(5552).orElse(null);

        // Validamos el cambio realizado
        Assertions.assertEquals("Efectivo", compraBuscada.getMetodoPago());

    }

    @Test
    @Sql("classpath:compras.sql")
    public void listar(){

        // Conseguimos todas las compras
        List<Compra> compras = compraRepositorio.findAll();

        // Y se imprimen
        compras.forEach(u -> System.out.println(u));
        System.out.println(compras);

    }

}
