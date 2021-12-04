package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepositorio extends JpaRepository<DetalleCompra, Integer>  {


    List<DetalleCompra> findAllByPrecioProducto(double precio);

    List<DetalleCompra> findAllByUnidades(int cantidad);
}
