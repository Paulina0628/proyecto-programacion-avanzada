package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepositorio extends JpaRepository<Mensaje, Integer> {


    List<Mensaje> findAllByChat(Chat chat);

    List<Mensaje>  findAllByEmisor(String emisor);
}
