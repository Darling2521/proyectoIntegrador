package bienestar.bffweb.agenda.citasagendadas;


import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.citasagendadas", url = "http://localhost:8083/api/citasagendadas")

public interface CitasAgendadasClient {
    
    @GetMapping("/{id}/")
    CitasAgendadasDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<CitasAgendadasDTO> findAll();

    @PostMapping("/")
    CitasAgendadasDTO save(CitasAgendadasDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    CitasAgendadasDTO update(@PathVariable("id") Long id, CitasAgendadasDTO entity);
    }