package bienestar.bffweb.fichaPaciente.ficha;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.ficha", url = "http://localhost:8084/api/ficha")

public interface FichaClient {
    
    @GetMapping("/{id}/")
    FichaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<FichaDTO> findAll();

    @PostMapping("/")
    FichaDTO save(FichaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    FichaDTO update(@PathVariable("id") Long id, FichaDTO entity);
    }
