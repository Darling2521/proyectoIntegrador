package fichaPaciente.api_ficha.genero;

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
@RequestMapping("api/genero")
@CrossOrigin({
        "*"
    })
public class  GeneroController {
    @Autowired
    GeneroService generoService;

    @GetMapping("/")
    public List< Genero> findAll() {
        return generoService.findAll();
        }

    @GetMapping("/{id}/")
    public  Genero findById(@PathVariable Long id) {
        return generoService.findById(id);
        }

    @PostMapping("/")
    public  Genero save(@RequestBody  Genero entity) {
        return generoService.save(entity);
        }

    @PutMapping("/{id}/")
    public  Genero update(@RequestBody  Genero entity) {
        return generoService.save(entity);
        }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
       generoService.deleteById(id);
        }
    }
