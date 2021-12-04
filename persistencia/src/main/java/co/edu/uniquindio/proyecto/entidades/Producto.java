package co.edu.uniquindio.proyecto.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.*;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @ManyToMany(mappedBy = "productos")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "productosFavoritos")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "productoSubasta")
    @ToString.Exclude
    private List<Subasta> subastas;

    @OneToMany(mappedBy = "productoDetalleCompra")
    @ToString.Exclude
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "productoChat")
    @ToString.Exclude
    private List<Chat> chats;

    @ManyToOne
    @JoinColumn(name = "codigo_ciudad")
    private Ciudad ciudad;

    @OneToMany(mappedBy = "productoComentado")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @ManyToOne
    @JoinColumn(name = "codigo_vendedor")
    private Usuario vendedor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ElementCollection
    @Column(name = "imagen", nullable = false)
    private Map<Integer, String> imagenes;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer unidades;

    private String descripcion;
    private double descuento;

    @Column(nullable = false)
    private double precio;

    @Column(name = "fecha_limite", nullable = false)
    private LocalDateTime fechaLimite;



    public Producto(String nombre, Integer unidades, String descripcion, double precio, LocalDateTime fechaLimite, double descuento) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.descuento = descuento;
    }

    public Producto(Ciudad ciudad, Usuario vendedor, Integer codigo, String nombre, Integer unidades, String descripcion, double descuento, double precio, LocalDateTime fechaLimite) {
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
    }
}
