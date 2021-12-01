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
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto productoDetalleCompra;

    @ManyToOne
    @JoinColumn(name = "codigo_compra")
    private Compra compraDetalleCompra;

    @Column(nullable = false)
    private Integer unidades;

    @Column(nullable = false)
    private double precioProducto;

    public DetalleCompra(Integer unidades, double precioProducto) {
        this.unidades = unidades;
        this.precioProducto = precioProducto;
    }

    public DetalleCompra(Integer codigo, Producto productoDetalleCompra, Compra compraDetalleCompra, Integer unidades, double precioProducto) {
        this.codigo = codigo;
        this.productoDetalleCompra = productoDetalleCompra;
        this.compraDetalleCompra = compraDetalleCompra;
        this.unidades = unidades;
        this.precioProducto = precioProducto;
    }
}
