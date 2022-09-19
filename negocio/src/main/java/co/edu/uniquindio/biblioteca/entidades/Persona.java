package co.edu.uniquindio.biblioteca.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Herencia
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;
}
