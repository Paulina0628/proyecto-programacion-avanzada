package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPrestamo;


    private LocalDateTime fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo() {
        super();
    }

    //public Prestamo(LocalDateTime fechaPrestamo, LocalDate fechaDevolucion) {
       // this.fechaPrestamo = fechaPrestamo;
       // this.fechaDevolucion = fechaDevolucion;
   // }

    public Integer getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(Integer codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prestamo prestamo = (Prestamo) o;

        return Objects.equals(codigoPrestamo, prestamo.codigoPrestamo);
    }

    @Override
    public int hashCode() {
        return codigoPrestamo != null ? codigoPrestamo.hashCode() : 0;
    }
}
