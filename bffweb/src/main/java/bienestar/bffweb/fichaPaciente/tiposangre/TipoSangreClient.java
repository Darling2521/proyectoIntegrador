package bienestar.bffweb.fichaPaciente.tiposangre;



import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.tiposangre", url = "http://localhost:8084/api/tiposangre")

public interface TipoSangreClient {
    
    @GetMapping("/{id}/")
    TipoSangreDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<TipoSangreDTO> findAll();

    @PostMapping("/")
    TipoSangreDTO save(TipoSangreDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    TipoSangreDTO update(@PathVariable("id") Long id, TipoSangreDTO entity);
    }
