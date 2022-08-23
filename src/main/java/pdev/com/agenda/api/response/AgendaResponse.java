package pdev.com.agenda.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // cria uma notação padrão
public class AgendaResponse {

    private long id;

    private String descricao;

    private LocalDateTime horario;

    private LocalDateTime dataCriacao;

    private PacienteResponse paciente;

    //AllArgsContrutor
    //public AgendaResponse(Long id, String descricao){
    //this.id = id;
    //}
}
