package catalogo.api_catalogo.diagnostico;

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
@RequestMapping("api/diagnostico")
@CrossOrigin({ "*" })
public class DiagnosticoController {
    @Autowired
    DiagnosticoService diagnosticoService;

    @GetMapping("/")
    public List<Diagnostico> findAll() {
        return diagnosticoService.findAll();
    }

    @GetMapping("/{id}/")
    public Diagnostico findById(@PathVariable Long id) {
        return diagnosticoService.findById(id);
    }

    @PostMapping("/")
    public Diagnostico save(@RequestBody Diagnostico entity) {
        return diagnosticoService.save(entity);
    }

    @PutMapping("/{id}/")
    public Diagnostico update(@RequestBody Diagnostico entity) {
        return diagnosticoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        diagnosticoService.deleteById(id);
    }
}
