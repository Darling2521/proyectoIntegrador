package bienestar.bffweb.fichaPaciente.genero;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.genero", url = "http://localhost:8084/api/genero")

public interface GeneroClient {
    
    @GetMapping("/{id}/")
    GeneroDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<GeneroDTO> findAll();

    @PostMapping("/")
    GeneroDTO save(GeneroDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    GeneroDTO update(@PathVariable("id") Long id, GeneroDTO entity);
    }