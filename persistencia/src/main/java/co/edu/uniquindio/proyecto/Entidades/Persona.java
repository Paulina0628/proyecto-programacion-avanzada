package co.edu.uniquindio.proyecto.Entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Persona implements Serializable {

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 14, nullable = false)
    private String contrasenia;

    public Persona(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }
}
