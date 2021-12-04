package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UsuarioYProducto {

    private String email;
    private String nombre;
    private List<Producto> productos;

}
