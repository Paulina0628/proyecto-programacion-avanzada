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
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToMany(mappedBy = "compraDetalleCompra")
    private List<DetalleCompra> comprasDetalleCompras;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario compraUsuario;

    @Column(nullable = false)
    private String fechaCompra;

    @Column(length = 100, nullable = false)
    private String metodoPago;

    public Compra(String fechaCompra, String metodoPago) {
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
    }
}
