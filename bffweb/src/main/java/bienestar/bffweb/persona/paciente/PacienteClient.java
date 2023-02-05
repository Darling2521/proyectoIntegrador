package bienestar.bffweb.persona.paciente;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.paciente", url = "http://localhost:8000/api/paciente")

public interface PacienteClient {
    
    @GetMapping("/{id}/")
    PacienteDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<PacienteDTO> findAll();

    @PostMapping("/")
    PacienteDTO save(PacienteDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    PacienteDTO update(@PathVariable("id") Long id, PacienteDTO entity);
    }
//@PutMapping("/{id}/completardatos/")
    //PacienteDTO completardatos(@PathVariable("id") Long id);