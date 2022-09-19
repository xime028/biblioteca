package co.edu.uniquindio.biblioteca.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter // Genera los getters de todos los atributos sin necesidad de crearlos gracias Lombok
@Setter // Genera los setters de todos los atributos sin necesidad de crearlos gracias Lombok
@NoArgsConstructor // Genera el constructor vacio
@AllArgsConstructor // Genera el construtor con todos los atributos
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Genera el equals y el hashcode
@ToString
public class Prestamo implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fechaPrestamo;

    @Column(nullable = false)
    private LocalDate fechaDevolucion;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Libro>libros;
}
