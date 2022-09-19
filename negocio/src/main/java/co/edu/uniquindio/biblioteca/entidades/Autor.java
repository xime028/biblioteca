package co.edu.uniquindio.biblioteca.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter // Genera los getters de todos los atributos sin necesidad de crearlos gracias Lombok
@Setter // Genera los setters de todos los atributos sin necesidad de crearlos gracias Lombok
@NoArgsConstructor // Genera el constructor vacio
@AllArgsConstructor // Genera el construtor con todos los atributos
@ToString
public class Autor extends Persona implements Serializable {

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
}
