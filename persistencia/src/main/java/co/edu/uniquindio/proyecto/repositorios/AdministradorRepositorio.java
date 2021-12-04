package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Integer> {

    List<Administrador> findAllByNombreContains(String nombre);

    Optional<Administrador> findByEmail(String nombre);
}
