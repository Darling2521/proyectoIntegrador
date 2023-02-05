package bienestar.bffweb.agenda.estado;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.estado", url = "http://localhost:8083/api/estado")

public interface EstadoClient {
    
    @GetMapping("/{id}/")
    EstadoDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<EstadoDTO> findAll();

    @PostMapping("/")
    EstadoDTO save(EstadoDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    EstadoDTO update(@PathVariable("id") Long id, EstadoDTO entity);
    }
