package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.SubastaUsuario;
import co.edu.uniquindio.proyecto.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubastaUsuarioRepositorio extends JpaRepository<SubastaUsuario, Integer> {

}
