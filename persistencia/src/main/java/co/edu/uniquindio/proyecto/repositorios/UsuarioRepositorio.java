package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
