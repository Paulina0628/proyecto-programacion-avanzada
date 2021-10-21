package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.Entidades.Subasta;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubastaRepositorio extends JpaRepository<Subasta, Integer> {
}
