package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 20)
    private String isbn;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer anio;

    @Positive
    @Column(nullable = false)
    private Integer unidades;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroLibro genero;

    @ManyToMany(mappedBy = "librosPrestado")
    private List<Prestamo> prestamoLibro;

    @ManyToMany
    private List<Autor> autoresLibro;

    public Libro(String isbn, String nombre, Integer anio, Integer unidades) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.anio = anio;
        this.unidades = unidades;
    }

}
