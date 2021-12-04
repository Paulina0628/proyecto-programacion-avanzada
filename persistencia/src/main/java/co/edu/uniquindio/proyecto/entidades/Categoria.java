package co.edu.uniquindio.proyecto.entidades;

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
public class Categoria implements Serializable {

    @JoinTable(
            name = "categoria_producto",
            joinColumns = @JoinColumn(name = "codigo_categoria", nullable = false),
            inverseJoinColumns = @JoinColumn(name="codigo_producto", nullable = false)
    )
    @ManyToMany
    private List<Producto> productos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
