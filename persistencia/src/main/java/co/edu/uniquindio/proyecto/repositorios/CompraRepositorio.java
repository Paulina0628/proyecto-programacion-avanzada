package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, Integer> {

    List<Compra> findAllByCompraUsuario(Usuario compraUsuario);

    List<Compra>  findAllByFechaCompra(String fecha);

    List<Compra> findAllByMetodoPago(String metodo);



}
