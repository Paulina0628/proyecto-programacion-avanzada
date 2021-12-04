package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.SubastaUsuario;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaUsuarioRepositorio extends JpaRepository<SubastaUsuario, Integer> {


    List<SubastaUsuario> findAllByUsuarioSubasta(Usuario usuario);

    List<SubastaUsuario> findAllByValor(double valor);

    List<SubastaUsuario> findAllByFechaSubasta(String fecha);

}
