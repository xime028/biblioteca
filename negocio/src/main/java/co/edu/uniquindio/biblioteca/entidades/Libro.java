package co.edu.uniquindio.biblioteca.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter // Genera los getters de todos los atributos sin necesidad de crearlos gracias Lombok
@Setter // Genera los setters de todos los atributos sin necesidad de crearlos gracias Lombok
@NoArgsConstructor // Genera el constructor vacio
@AllArgsConstructor // Genera el construtor con todos los atributos
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Genera el equals y el hashcode
@ToString
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String isbn;

    @Column(nullable = false)
    private String nombre;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer unidades;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer anio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @ManyToMany(mappedBy = "libros")
    private List<Prestamo> prestamos;

    @ManyToMany
    private List<Autor>autores;
}
