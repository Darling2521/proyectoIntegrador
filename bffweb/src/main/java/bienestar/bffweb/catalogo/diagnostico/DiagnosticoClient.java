package bienestar.bffweb.catalogo.diagnostico;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.diagnostico", url = "http://localhost:8082/api/diagnostico")

public interface DiagnosticoClient {
    
    @GetMapping("/{id}/")
    DiagnosticoDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<DiagnosticoDTO> findAll();

    @PostMapping("/")
    DiagnosticoDTO save(DiagnosticoDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    DiagnosticoDTO update(@PathVariable("id") Long id, DiagnosticoDTO entity);
    }