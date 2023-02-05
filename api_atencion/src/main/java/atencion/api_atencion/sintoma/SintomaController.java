package atencion.api_atencion.sintoma;

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
@RequestMapping("api/sintoma")
@CrossOrigin({ "*" })
public class SintomaController {
    @Autowired
    SintomaService sintomaService;

    @GetMapping("/")
    public List<Sintoma> findAll() {
        return sintomaService.findAll();
    }

    @GetMapping("/{id}/")
    public Sintoma findById(@PathVariable Long id) {
        return sintomaService.findById(id);
    }

    @PostMapping("/")
    public Sintoma save(@RequestBody Sintoma entity) {
        return sintomaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Sintoma update(@RequestBody Sintoma entity) {
        return sintomaService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        sintomaService.deleteById(id);
    }
}
