package fichaPaciente.api_ficha.tiposangre;

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
@RequestMapping("api/tiposangre")
@CrossOrigin({
        "*"
    })
public class  TipoSangreController {
    @Autowired
    TipoSangreService tiposangreService;

    @GetMapping("/")
    public List< TipoSangre> findAll() {
        return tiposangreService.findAll();
        }

    @GetMapping("/{id}/")
    public  TipoSangre findById(@PathVariable Long id) {
        return tiposangreService.findById(id);
        }

    @PostMapping("/")
    public  TipoSangre save(@RequestBody  TipoSangre entity) {
        return tiposangreService.save(entity);
        }

    @PutMapping("/{id}/")
    public  TipoSangre update(@RequestBody  TipoSangre entity) {
        return tiposangreService.save(entity);
        }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
       tiposangreService.deleteById(id);
        }
    }
