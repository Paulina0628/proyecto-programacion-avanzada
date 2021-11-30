package co.edu.uniquindio.proyecto.Entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {

    @JoinTable(
            name = "favorito",
            joinColumns = @JoinColumn(name = "codigo_usuario", nullable = false),
            inverseJoinColumns = @JoinColumn(name="codigo_producto", nullable = false)
    )
    @ManyToMany
    private List<Producto> productosFavoritos;

    @ManyToOne
    @JoinColumn(name = "codigo_ciudad")
    private Ciudad ciudadUsuario;

    @OneToMany(mappedBy = "compraUsuario")
    @ToString.Exclude
    private List<Compra> compras;

    @OneToMany(mappedBy = "chatUsuario")
    @ToString.Exclude
    private List<Chat> chats;

    @OneToMany(mappedBy = "vendedor")
    @ToString.Exclude
    private List<Producto> productosVenta;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuarioSubasta")
    @ToString.Exclude
    private List<SubastaUsuario> usuarioSubastas;

    @ElementCollection
    @Column(name = "telefono", nullable = false)
    private Map<String, String> telefonos;

    public Usuario(Integer codigo, String nombre, String email, String contrasenia, List<Producto> productosFavoritos, Ciudad ciudadUsuario, List<Compra> compras, List<Chat> chats, List<Producto> productosVenta, List<Comentario> comentarios, List<SubastaUsuario> usuarioSubastas, Map<String, String> telefonos) {
        super(codigo, nombre, email, contrasenia);
        this.productosFavoritos = productosFavoritos;
        this.ciudadUsuario = ciudadUsuario;
        this.compras = compras;
        this.chats = chats;
        this.productosVenta = productosVenta;
        this.comentarios = comentarios;
        this.usuarioSubastas = usuarioSubastas;
        this.telefonos = telefonos;
    }

    public Usuario(Integer codigo, String nombre, String email, String contrasenia, Ciudad ciudadUsuario, Map<String, String> telefonos) {
        super(codigo, nombre, email, contrasenia);
        this.ciudadUsuario = ciudadUsuario;
        this.telefonos = telefonos;
    }
}
