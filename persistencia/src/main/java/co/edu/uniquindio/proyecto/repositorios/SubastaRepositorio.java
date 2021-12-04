package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepositorio extends JpaRepository<Subasta, Integer> {


    List<Subasta> findAllByProductoSubasta(Producto productoSubasta);

    List<Subasta> findAllByFechaLimite(String fecha);
}
