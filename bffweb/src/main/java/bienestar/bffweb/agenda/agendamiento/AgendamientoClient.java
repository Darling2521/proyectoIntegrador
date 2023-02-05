package bienestar.bffweb.agenda.agendamiento;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.agendamiento", url = "http://localhost:8083/api/agendamiento")

public interface AgendamientoClient {
    
    @GetMapping("/{id}/")
    AgendamientoDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<AgendamientoDTO> findAll();

    @PostMapping("/")
    AgendamientoDTO save(AgendamientoDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    AgendamientoDTO update(@PathVariable("id") Long id, AgendamientoDTO entity);
    }
