package tratamiento.api_catalogo.sintomas;

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
@RequestMapping("api/sintomas")
@CrossOrigin({"*"})
public class SintomasController {
@Autowired SintomasService sintomasService;
     @GetMapping("/")
     public List<Sintomas> findAll(){
     return sintomasService.findAll();
     }
     @GetMapping("/{id}")
     public Sintomas findById(@PathVariable Long id){
     return sintomasService.findById(id);
     }
     @PostMapping("/")
     public Sintomas save(@RequestBody Sintomas entity){
     return sintomasService.save(entity);
     }
     @PutMapping("/")
     public Sintomas update(@RequestBody Sintomas entity){
     return sintomasService.save(entity);
     }
     @DeleteMapping("/{id}/")
     public void deleteById(@PathVariable Long id){
     sintomasService.deleteById(id);
     }

}
