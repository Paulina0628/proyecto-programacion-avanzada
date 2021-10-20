package co.edu.uniquindio.proyecto.Entidades;

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
public class SubastaUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_subasta")
    private Subasta subasta;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuarioSubasta;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private String fechaSubasta;





}
