package bienestar.bffweb.fichaPaciente.ficha;

import bienestar.bffweb.fichaPaciente.ciudad.CiudadDTO;
import bienestar.bffweb.fichaPaciente.genero.GeneroDTO;
import bienestar.bffweb.fichaPaciente.ocupacion.OcupacionDTO;
import bienestar.bffweb.fichaPaciente.tiposangre.TipoSangreDTO;
import lombok.Data;

@Data
public class FichaDTO {
    private Long id;
    private Long pacienteId;
    private String alergia;
    private String enfermedad;
    private String discapacidad;

    private GeneroDTO genero;
    private OcupacionDTO ocupacion;
    private TipoSangreDTO tiposangre;
    private CiudadDTO ciudad;
    

}
