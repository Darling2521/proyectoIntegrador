package bienestar.bffweb.agenda.citasagendadas;

import bienestar.bffweb.agenda.agendamiento.AgendamientoDTO;
import bienestar.bffweb.agenda.estado.EstadoDTO;
import lombok.Data;
@Data
public class CitasAgendadasDTO {

    private Long id;
    private AgendamientoDTO agendamiento;
    private EstadoDTO estado;
    
}
