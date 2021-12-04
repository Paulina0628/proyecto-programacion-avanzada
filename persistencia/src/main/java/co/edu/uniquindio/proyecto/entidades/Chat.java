package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Exclude
    private Integer codigo;

    @OneToMany(mappedBy = "chat")
    @ToString.Exclude
    private List<Mensaje> mensajes;

    @ManyToOne
    @JoinColumn(name = "usuario_comprador")
    private Usuario chatUsuario;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Usuario productoChat;

    public Chat(Integer codigo, Usuario chatUsuario, Usuario productoChat) {
        this.codigo = codigo;
        this.chatUsuario = chatUsuario;
        this.productoChat = productoChat;
    }
}
