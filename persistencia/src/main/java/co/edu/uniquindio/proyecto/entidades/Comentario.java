package co.edu.uniquindio.proyecto.entidades;

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
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto productoComentado;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Producto usuario;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private String fechaComentario;

    @Column(precision = 1, scale = 1, nullable = true)
    private double calificacion;

    public Comentario(String mensaje, String respuesta, String fechaMensaje, double calificacion) {
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fechaComentario = fechaMensaje;
        this.calificacion = calificacion;
    }

    public Comentario(Integer codigo, Producto productoComentado, String mensaje, String respuesta, String fechaComentario, double calificacion) {
        this.codigo = codigo;
        this.productoComentado = productoComentado;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fechaComentario = fechaComentario;
        this.calificacion = calificacion;
    }
}
