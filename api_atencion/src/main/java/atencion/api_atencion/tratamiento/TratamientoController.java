package atencion.api_atencion.tratamiento;

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
import java.util.List;

@RestController
@RequestMapping("api/tratamiento")
@CrossOrigin({ "*" })
public class TratamientoController {
    @Autowired
    TratamientoService tratamientoService;

    @GetMapping("/")
    public List<Tratamiento> findAll() {
        return tratamientoService.findAll();
    }

    @GetMapping("/{id}/")
    public Tratamiento findById(@PathVariable Long id) {
        return tratamientoService.findById(id);
    }

    @PostMapping("/")
    public Tratamiento save(@RequestBody Tratamiento entity) {
        return tratamientoService.save(entity);
    }

    @PutMapping("/{id}/")
    public Tratamiento update(@RequestBody Tratamiento entity) {
        return tratamientoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        tratamientoService.deleteById(id);
    }
}
