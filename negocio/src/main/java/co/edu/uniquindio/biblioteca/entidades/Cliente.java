package co.edu.uniquindio.biblioteca.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter // Genera los getters de todos los atributos sin necesidad de crearlos gracias Lombok
@Setter // Genera los setters de todos los atributos sin necesidad de crearlos gracias Lombok
@NoArgsConstructor // Genera el constructor vacio
@ToString
public class Cliente extends Persona implements Serializable {

    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @ElementCollection
    private Map<String, String > telefonos;

    @ToString.Exclude
    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Prestamo> prestamos;

    @Builder
    public Cliente(Integer codigo, String nombre, LocalDate fechaNacimiento, String email, Map<String, String> telefonos) {
        super(codigo, nombre, fechaNacimiento);
        this.email = email;
        this.telefonos = telefonos;
        //this.ciudad = ciudad;
    }
}
