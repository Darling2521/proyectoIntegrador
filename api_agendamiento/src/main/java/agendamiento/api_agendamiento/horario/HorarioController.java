package agendamiento.api_agendamiento.horario;

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
@RequestMapping("api/horario")
@CrossOrigin({ "*" })
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    @GetMapping("/")
    public List<Horario> findAll() {
        return horarioService.findAll();
    }

    @GetMapping("/{id}/")
    public Horario findById(@PathVariable Long id) {
        return horarioService.findById(id);
    }

    @PostMapping("/")
    public Horario save(@RequestBody Horario entity) {
        return horarioService.save(entity);
    }

    @PutMapping("/{id}/")
    public Horario update(@RequestBody Horario entity) {
        return horarioService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        horarioService.deleteById(id);
    }
}
