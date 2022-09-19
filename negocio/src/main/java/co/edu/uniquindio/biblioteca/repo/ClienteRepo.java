package co.edu.uniquindio.biblioteca.repo;

import co.edu.uniquindio.biblioteca.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // componente de Spring Data
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
