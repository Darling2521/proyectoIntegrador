package bienestar.bffweb.catalogo.tratamiento;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.tratamiento", url = "http://localhost:8082/api/tratamiento")

public interface TratamientoClient {
    
    @GetMapping("/{id}/")
    TratamientoDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<TratamientoDTO> findAll();

    @PostMapping("/")
    TratamientoDTO save(TratamientoDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    TratamientoDTO update(@PathVariable("id") Long id, TratamientoDTO entity);
    }
