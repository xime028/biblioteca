package co.edu.uniquindio.biblioteca.test;

import ch.qos.logback.core.net.SyslogOutputStream;
import co.edu.uniquindio.biblioteca.entidades.Ciudad;
import co.edu.uniquindio.biblioteca.entidades.Cliente;
import co.edu.uniquindio.biblioteca.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar(){

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Casa", "1346777");

        Cliente cliente = new Cliente(1234, "pepito", LocalDate.of(2001, 05, 18), "pepe@gmail.com",telefonos);

        Cliente guardado = clienteRepo.save(cliente);
        Assertions.assertEquals("pepito", guardado.getNombre());
    }

    @Test
    public void eliminar(){
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Casa", "1346777");

        Cliente cliente = new Cliente(1234, "pepito", LocalDate.of(2001, 05, 18), "pepe@gmail.com",telefonos);
        Cliente guardado = clienteRepo.save(cliente);

        clienteRepo.delete(guardado);

        Optional<Cliente> buscado = clienteRepo.findById(1234);

        Assertions.assertNull(buscado.orElse(null));

    }

    @Test
    public void actualizar(){

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Casa", "1346777");

        Cliente cliente = new Cliente(1234, "pepito", LocalDate.of(2001, 05, 18), "pepe@gmail.com",telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        guardado.setEmail("pablo@gmail.com");

        Cliente nuevo = clienteRepo.save(guardado);

        Assertions.assertEquals("pablo@gmail.com", nuevo.getEmail());

    }

    @Test
    public void obtener (){

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Casa", "1346777");

        Cliente cliente = new Cliente(1234, "pepito", LocalDate.of(2001, 05, 18), "pepe@gmail.com",telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        Optional<Cliente> buscado = clienteRepo.findById(1234);

        System.out.println(buscado.orElse(null));

    }

    @Test
    public void listar(){

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Casa", "1346777");

        Cliente cliente = new Cliente(1234, "pepito", LocalDate.of(2001, 05, 18), "pepe@gmail.com",telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        List<Cliente> lista = clienteRepo.findAll();

        System.out.println(lista);
    }
}
