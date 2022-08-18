package pdev.com.agenda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdev.com.agenda.domain.entity.Paciente;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    //O spring data jpa ira ajudar no metodo apra filtrar por cpf
    Optional<Paciente> findByCpf(String cpf);
}
