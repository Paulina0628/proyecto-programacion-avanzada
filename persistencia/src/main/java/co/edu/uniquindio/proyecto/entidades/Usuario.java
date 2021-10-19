package co.edu.uniquindio.proyecto.entidades;

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
public class Usuario extends Persona implements Serializable {

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> numTelefono;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamo;

    public Usuario(String email) {
        this.email = email;
    }

}
