package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepositorio extends JpaRepository<Chat, Integer> {

    List<Chat> findAllByChatUsuario(Usuario usuarioChat);

    Optional<Chat> findByProductoChat(Usuario productoChat);
}
