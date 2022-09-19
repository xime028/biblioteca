package co.edu.uniquindio.biblioteca.repo;

import co.edu.uniquindio.biblioteca.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

}
