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
public class Subasta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto productoSubasta;

    @OneToMany(mappedBy = "subasta")
    private List<SubastaUsuario> usuarioSubastas;

    @Column(name = "fecha_limite", nullable = false)
    private String fechaLimite;

    public Subasta(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Subasta(Integer codigo, Producto productoSubasta, String fechaLimite) {
        this.codigo = codigo;
        this.productoSubasta = productoSubasta;
        this.fechaLimite = fechaLimite;
    }
}
