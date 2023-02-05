package bienestar.bffweb.atencion;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.atencion", url = "http://localhost:8086/api/atencion")

public interface AtencionClient {
    
    @GetMapping("/{id}/")
    AtencionDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<AtencionDTO> findAll();

    @PostMapping("/")
    AtencionDTO save(AtencionDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    AtencionDTO update(@PathVariable("id") Long id, AtencionDTO entity);
    }
