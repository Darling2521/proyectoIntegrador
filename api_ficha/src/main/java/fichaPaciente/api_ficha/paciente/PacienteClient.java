package fichaPaciente.api_ficha.paciente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bff.paciente", url = "http://localhost:8000/api/paciente")
public interface PacienteClient {
    @GetMapping("/{id}/")
    PacienteDTO findPacienteById(@PathVariable("id") Long id);
}
