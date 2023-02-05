package bienestar.bffweb.agenda.horario;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.horario", url = "http://localhost:8083/api/horario")

public interface HorarioClient {
    
    @GetMapping("/{id}/")
    HorarioDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<HorarioDTO> findAll();

    @PostMapping("/")
    HorarioDTO save(HorarioDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    HorarioDTO update(@PathVariable("id") Long id, HorarioDTO entity);
    }
