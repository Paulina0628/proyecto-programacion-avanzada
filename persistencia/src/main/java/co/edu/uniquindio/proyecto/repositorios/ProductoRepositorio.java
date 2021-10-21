package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.Entidades.Producto;
import co.edu.uniquindio.proyecto.Entidades.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
