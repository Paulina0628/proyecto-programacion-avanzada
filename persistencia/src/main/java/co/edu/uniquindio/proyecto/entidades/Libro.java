package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String isbn;
    private String nombre;
    private Integer anio;
    private Integer unidades;

    public Libro(String isbn, String nombre, Integer anio, Integer unidades) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.anio = anio;
        this.unidades = unidades;
    }

}
