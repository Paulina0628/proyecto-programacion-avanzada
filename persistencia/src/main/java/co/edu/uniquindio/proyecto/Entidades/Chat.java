package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer codigo;

    @OneToMany(mappedBy = "chat")
    private List<Mensaje> mensajes;

    @ManyToOne
    @JoinColumn(name = "usuario_comprador")
    private Usuario chatUsuario;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Usuario productoChat;

}
