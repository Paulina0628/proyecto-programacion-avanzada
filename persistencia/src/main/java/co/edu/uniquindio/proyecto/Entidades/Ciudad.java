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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToMany(mappedBy = "ciudad")
    private List<Producto> productos;

    @OneToMany(mappedBy = "ciudadUsuario")
    private List<Usuario> usuarios;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
}
