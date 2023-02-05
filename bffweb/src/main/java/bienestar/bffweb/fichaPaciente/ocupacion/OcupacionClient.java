package bienestar.bffweb.fichaPaciente.ocupacion;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.ocupacion", url = "http://localhost:8084/api/ocupacion")

public interface OcupacionClient {
    
    @GetMapping("/{id}/")
    OcupacionDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<OcupacionDTO> findAll();

    @PostMapping("/")
    OcupacionDTO save(OcupacionDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    OcupacionDTO update(@PathVariable("id") Long id, OcupacionDTO entity);
    }