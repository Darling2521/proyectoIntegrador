package bienestar.bffweb.catalogo.sintoma;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.sintoma", url = "http://localhost:8082/api/sintoma")

public interface SintomaClient {
    
    @GetMapping("/{id}/")
    SintomaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<SintomaDTO> findAll();

    @PostMapping("/")
    SintomaDTO save(SintomaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    SintomaDTO update(@PathVariable("id") Long id, SintomaDTO entity);
    }