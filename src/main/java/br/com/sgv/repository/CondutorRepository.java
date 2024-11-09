package br.com.sgv.repository;

import br.com.sgv.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


public interface CondutorRepository extends JpaRepository<Condutor, Long> {
    List<Condutor> findByNomeDono(String nomeDono);
}



