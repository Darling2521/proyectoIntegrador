package bienestar.bffweb.persona.especialista;

import java.sql.Date;

import lombok.Data;

@Data
public class EspecialistaDTO {

    private Long id;
    private String nombre;
    private Integer cedula;
    private Date fecha_nacimiento;
    private String telefono;
    private String correo;
    private String especialidad;
    
}
