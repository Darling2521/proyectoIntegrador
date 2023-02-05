package bienestar.bffweb.fichaPaciente.ciudad;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.ciudad", url = "http://localhost:8084/api/ciudad")

public interface CiudadClient {
    
    @GetMapping("/{id}/")
    CiudadDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<CiudadDTO> findAll();

    @PostMapping("/")
    CiudadDTO save(CiudadDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    CiudadDTO update(@PathVariable("id") Long id, CiudadDTO entity);
    }