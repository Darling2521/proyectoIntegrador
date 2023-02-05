package fichaPaciente.api_ficha.paciente;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PacienteDTO {
    private Long id;
    private String nombre;
    private Integer cedula;
    private LocalDate fecha_nacimiento;
    private String telefono;
    private String correo;
}

