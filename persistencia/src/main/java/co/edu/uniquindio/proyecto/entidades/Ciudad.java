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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Producto> productos;

    @OneToMany(mappedBy = "ciudadUsuario")
    @ToString.Exclude
    private List<Usuario> usuarios;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
