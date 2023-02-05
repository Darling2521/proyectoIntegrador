package bienestar.bffweb.agenda.horario;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data

public class HorarioDTO {
    private Long id;
    private Date fecha;
    private Time hora;
    private Long especialistaId;
    
}
