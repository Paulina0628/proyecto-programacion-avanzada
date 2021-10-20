package co.edu.uniquindio.proyecto.Entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<Subasta> subastas;

    @OneToMany(mappedBy = "productoDetalleCompra")
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "productoChat")
    private List<Chat> chats;

    @ManyToOne
    @JoinColumn(name = "codigo_ciudad")
    private Ciudad ciudad;

    @OneToMany(mappedBy = "productoComentado")
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

    @Column(nullable = false)
    private double precio;

    @Column(name = "fecha_limite", nullable = false)
    private String fechaLimite;

    private double descuento;

    public Producto(String nombre, Integer unidades, String descripcion, double precio, String fechaLimite, double descuento) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.descuento = descuento;
    }
}
