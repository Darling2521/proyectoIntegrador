package fichaPaciente.api_ficha.ciudad;

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
@RequestMapping("api/ciudad")
@CrossOrigin({
        "*"
    })
public class  CiudadController {
    @Autowired
    CiudadService ciudadService;

    @GetMapping("/")
    public List< Ciudad> findAll() {
        return ciudadService.findAll();
        }

    @GetMapping("/{id}/")
    public  Ciudad findById(@PathVariable Long id) {
        return ciudadService.findById(id);
        }

    @PostMapping("/")
    public  Ciudad save(@RequestBody  Ciudad entity) {
        return ciudadService.save(entity);
        }

    @PutMapping("/{id}/")
    public  Ciudad update(@RequestBody  Ciudad entity) {
        return ciudadService.save(entity);
        }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
       ciudadService.deleteById(id);
        }
    }
