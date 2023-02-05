package bienestar.bffweb.persona.paciente;

import java.sql.Date;

import lombok.Data;
@Data
public class PacienteDTO {
    
    private Long id;
    private String nombre;
    private Integer cedula;
    private Date fecha_nacimiento;
    private String telefono;
    private String correo;

}
