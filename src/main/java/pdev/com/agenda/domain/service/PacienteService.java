package pdev.com.agenda.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdev.com.agenda.domain.entity.Paciente;
import pdev.com.agenda.domain.repository.PacienteRepository;
import pdev.com.agenda.exception.BusinessException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

//    public PacienteService(PacienteRepository repository){
//        this.repository = repository;
//    }

    public Paciente salvar(Paciente paciente){
        //TODO: PARA VALIDAR SE O CPF JA NAO EXISTE
        //seria buscar um paciente por cpf

        boolean existeCpf = false;

        Optional<Paciente> optPaciente = repository.findByCpf(paciente.getCpf());

        if(optPaciente.isPresent()){
            if(!optPaciente.get().getId().equals(paciente.getId())){
                existeCpf = true;
            }
        }

        if(existeCpf){
            throw new BusinessException("Cpf ja cadastrado!");
        }

        return repository.save(paciente);
    }

    public Paciente alterar(Long id, Paciente paciente){
        Optional<Paciente> optPaciente = this.buscarPorId(id);

        if(optPaciente.isEmpty()){
            throw new BusinessException("Paciente não cadastro!");
        }
        paciente.setId(id);

        return salvar(paciente);
    }

    public List<Paciente> listarTodos(){
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
