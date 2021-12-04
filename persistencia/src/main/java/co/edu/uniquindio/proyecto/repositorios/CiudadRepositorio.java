package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad, Integer> {

    List<Ciudad> findAllByNombreContains(String nombre);

    @Query("select u from Ciudad c inner join c.usuarios u where c.nombre = :nombreCiudad")
    List<Usuario>  listarUsuarios(String nombreCiudad);


}
