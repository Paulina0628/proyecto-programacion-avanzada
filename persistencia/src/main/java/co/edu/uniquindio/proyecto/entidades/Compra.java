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
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToMany(mappedBy = "compraDetalleCompra")
    @ToString.Exclude
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

    public Compra(Integer codigo, Usuario compraUsuario, String fechaCompra, String metodoPago) {
        this.codigo = codigo;
        this.compraUsuario = compraUsuario;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
    }
}
