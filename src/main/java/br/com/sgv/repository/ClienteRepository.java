package br.com.sgv.repository;

import br.com.sgv.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome); // Método para buscar cliente por CPF
}

