package agendamiento.api_agendamiento.estado;

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
@RequestMapping("api/estado")
@CrossOrigin({ "*" })
public class EstadoController {
    @Autowired
    EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> findAll() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}/")
    public Estado findById(@PathVariable Long id) {
        return estadoService.findById(id);
    }

    @PostMapping("/")
    public Estado save(@RequestBody Estado entity) {
        return estadoService.save(entity);
    }

    @PutMapping("/{id}/")
    public Estado update(@RequestBody Estado entity) {
        return estadoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        estadoService.deleteById(id);
    }
}
