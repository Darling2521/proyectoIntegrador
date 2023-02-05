package fichaPaciente.api_ficha.ocupacion;

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
@RequestMapping("api/ocupacion")
@CrossOrigin({
        "*"
    })
public class  OcupacionController {
    @Autowired
    OcupacionService ocupacionService;

    @GetMapping("/")
    public List< Ocupacion> findAll() {
        return ocupacionService.findAll();
        }

    @GetMapping("/{id}/")
    public  Ocupacion findById(@PathVariable Long id) {
        return ocupacionService.findById(id);
        }

    @PostMapping("/")
    public  Ocupacion save(@RequestBody  Ocupacion entity) {
        return ocupacionService.save(entity);
        }

    @PutMapping("/{id}/")
    public  Ocupacion update(@RequestBody  Ocupacion entity) {
        return ocupacionService.save(entity);
        }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
       ocupacionService.deleteById(id);
        }
    }

