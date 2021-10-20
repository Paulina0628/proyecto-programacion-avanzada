package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_chat")
    private Chat chat;

    @Column(nullable = false)
    private String mensaje;

    @Column(length = 100, nullable = false)
    private String emisor;

    @Column(nullable = false)
    private String fecha;

    public Mensaje(String mensaje, String emisor, String fecha) {
        this.mensaje = mensaje;
        this.emisor = emisor;
        this.fecha = fecha;
    }
}
