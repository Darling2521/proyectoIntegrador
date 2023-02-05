package bienestar.bffweb.agenda.agendamiento;

import bienestar.bffweb.agenda.horario.HorarioDTO;
import lombok.Data;
@Data
public class AgendamientoDTO {

    private Long id;
    private Long pacienteId;
    private HorarioDTO horario;
    
}
