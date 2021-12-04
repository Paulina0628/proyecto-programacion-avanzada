package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer> {

    List<Comentario> findAllByCalificacion(double calificacion);

    List<Comentario> findAllByFechaComentario(String fecha);

    Optional<Comentario> findByProductoComentado(Producto producto);

    @Query("select c from Comentario c where c.calificacion > :calificacionMin and c.calificacion < :calificacionMax ")
    List<Comentario> listarComentariosEnRango(double calificacionMin, double calificacionMax);

}
