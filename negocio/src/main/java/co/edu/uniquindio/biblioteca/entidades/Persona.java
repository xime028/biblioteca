package co.edu.uniquindio.biblioteca.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter // Genera los getters de todos los atributos sin necesidad de crearlos gracias Lombok
@Setter // Genera los setters de todos los atributos sin necesidad de crearlos gracias Lombok
@NoArgsConstructor // Genera el constructor vacio
@AllArgsConstructor // Genera el construtor con todos los atributos
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Genera el equals y el hashcode
@ToString
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @ElementCollection
    private Map<String, String > telefonos;


}
