package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {


    List<Producto> findAllByPrecio(double precio);

    List<Producto> findAllByNombreContains(String nombre);

    List<Producto> findAllByVendedor(Usuario vendedor);

    List<Producto> findAllByCiudad(String ciudad);

    @Query("select p.vendedor.nombre from  Producto p where p.codigo = :id")
    String obtenerNombreVendedor(Integer id);

    @Query("select p.nombre,c from Producto p left join p.comentarios c ")
    List<Object[]> listarProductosYComentarios();

    @Query("select distinct c.usuario from Producto p join p.comentarios c where p.codigo = :id")
    List<Usuario> listarUsuariosComentarios(Integer id);

    @Query("select new co.edu.uniquindio.proyecto.dto.ProductoValido(p.nombre, p.descripcion, p.precio, p.ciudad) from Producto p where :fechaActual < p.fechaLimite")
    List<ProductoValido> listarProductosValidos(LocalDateTime fechaActual);
}
