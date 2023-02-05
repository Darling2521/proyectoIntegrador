package agendamiento.api_agendamiento.citasagendadas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/citasagendadas")
@CrossOrigin({ "*" })
public class CitasAgendadasController {
    @Autowired
    CitasAgendadasService citasAgendadasService;

    @GetMapping("/")
    public List<CitasAgendadas> findAll() {
        return citasAgendadasService.findAll();
    }

    @GetMapping("/{id}/")
    public CitasAgendadas findById(@PathVariable Long id) {
        return citasAgendadasService.findById(id);
    }

    @PostMapping("/")
    public CitasAgendadas save(@RequestBody CitasAgendadas entity) {
        return citasAgendadasService.save(entity);
    }

    @PutMapping("/{id}/")
    public CitasAgendadas update(@RequestBody CitasAgendadas entity) {
        return citasAgendadasService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        citasAgendadasService.deleteById(id);
    }
}
