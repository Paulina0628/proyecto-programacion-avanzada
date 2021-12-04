package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad, Integer> {


    List<Ciudad> findAllByNombreContains(String nombre);
}
