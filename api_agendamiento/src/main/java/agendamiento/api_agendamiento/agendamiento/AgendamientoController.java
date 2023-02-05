package agendamiento.api_agendamiento.agendamiento;

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
@RequestMapping("api/agendamiento")
@CrossOrigin({ "*" })
public class AgendamientoController {
    @Autowired
    AgendamientoService agendamientoService;

    @GetMapping("/")
    public List<Agendamiento> findAll() {
        return agendamientoService.findAll();
    }

    @GetMapping("/{id}/")
    public Agendamiento findById(@PathVariable Long id) {
        return agendamientoService.findById(id);
    }

    @PostMapping("/")
    public Agendamiento save(@RequestBody Agendamiento entity) {
        return agendamientoService.save(entity);
    }

    @PutMapping("/{id}/")
    public Agendamiento update(@RequestBody Agendamiento entity) {
        return agendamientoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        agendamientoService.deleteById(id);
    }
}
