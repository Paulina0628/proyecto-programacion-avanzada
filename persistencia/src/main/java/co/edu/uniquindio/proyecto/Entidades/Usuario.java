package co.edu.uniquindio.proyecto.Entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

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
    private List<Compra> compras;

    @OneToMany(mappedBy = "chatUsuario")
    private List<Chat> chats;

    @OneToMany(mappedBy = "vendedor")
    private List<Producto> productosVenta;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuarioSubasta")
    private List<SubastaUsuario> usuarioSubastas;

    @ElementCollection
    @Column(name = "telefono" ,nullable = false)
    private Map<Integer, String> telefonos;

    public Usuario(String nombre, String email, String contrasenia) {
        super(nombre, email, contrasenia);
    }
}
