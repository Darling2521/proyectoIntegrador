package fichaPaciente.api_ficha.ficha;

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
@RequestMapping("api/ficha")
@CrossOrigin({ "*" })
public class FichaController {
    @Autowired
    FichaService fichaService;

    @GetMapping("/")
    public List<Ficha> findAll() {
        return fichaService.findAll();
    }

    @GetMapping("/{id}/")
    public Ficha findById(@PathVariable Long id) {
        return fichaService.findById(id);
    }

    @PostMapping("/")
    public Ficha save(@RequestBody Ficha entity) {
        return fichaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Ficha update(@RequestBody Ficha entity) {
        return fichaService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        fichaService.deleteById(id);
    }
}