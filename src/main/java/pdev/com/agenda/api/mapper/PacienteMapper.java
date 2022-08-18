package pdev.com.agenda.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacienteMapper {

    private final ModelMapper mapper;

    public Paciente toPaciente(PacienteRequest request){
        return mapper.map(request, Paciente.class);
    }

    public PacienteResponse toPacienteResponse(Paciente paciente){
        return mapper.map(paciente, PacienteResponse.class);
    }



//    public static Paciente toPaciente(PacienteRequest request){
//        Paciente paciente = new Paciente();
//        paciente.setNome(request.getNome());
//        paciente.setSobrenome(request.getSobrenome());
//        paciente.setEmail(request.getEmail());
//        paciente.setCpf(request.getCpf());
//        return paciente;
//    }

//    public static PacienteResponse toPacienteResponse(Paciente paciente){
//        PacienteResponse response = new PacienteResponse();
//        response.setId(paciente.getId());
//        response.setNome(paciente.getNome());
//        response.setSobrenome(paciente.getSobrenome());
//        response.setEmail(paciente.getEmail());
//        response.setCpf(paciente.getCpf());
//        return response;
//    }

    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes){
       return pacientes.stream()
               .map(this::toPacienteResponse)
               .collect(Collectors.toList());
    }

//    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes){
//        List<PacienteResponse> responses = new ArrayList<>();
//        for(Paciente paciente : pacientes){
//            responses.add(toPacienteResponse(paciente));
//        }
//        return responses;
//    }
}
