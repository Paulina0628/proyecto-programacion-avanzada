package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Administrador extends Persona implements Serializable {

    public Administrador(Integer codigo, String nombre, String email, String contrasenia) {
        super(codigo, nombre, email, contrasenia);
    }
}
