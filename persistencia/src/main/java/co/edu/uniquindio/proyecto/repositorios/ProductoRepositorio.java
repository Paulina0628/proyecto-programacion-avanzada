package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {


    List<Producto> findAllByPrecio(double precio);

    List<Producto> findAllByNombreContains(String nombre);

    List<Producto> findAllByVendedor(Usuario vendedor);

    List<Producto> findAllByCiudad(String ciudad);
}
