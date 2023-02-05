package bienestar.bffweb.atencion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import lombok.Data;
@Data
public class AtencionDTO {
    
    private Long id;
    private String nro;
    private LocalDate fecha;
    private Long pacienteId;
    private Long especialistaId;
    private Long diagnosticoId;

    private List<SintomaDTO> sintoma = new ArrayList<>(); 
    private List<TratamientoDTO> tratamiento = new ArrayList<>();
    
}
