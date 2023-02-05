package bienestar.bffweb.persona.especialista;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.especialista", url = "http://localhost:8000/api/especialista")

public interface EspecialistaClient {
    
    @GetMapping("/{id}/")
    EspecialistaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<EspecialistaDTO> findAll();

    @PostMapping("/")
    EspecialistaDTO save(EspecialistaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    EspecialistaDTO update(@PathVariable("id") Long id, EspecialistaDTO entity);
    }