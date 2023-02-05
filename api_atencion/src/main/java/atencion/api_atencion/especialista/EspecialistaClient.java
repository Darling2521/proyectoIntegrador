package atencion.api_atencion.especialista;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bff.especialista", url = "http://localhost:8000/api/especialista")
public interface EspecialistaClient {
    @GetMapping("/{id}/")
    EspecialistaDTO findEspecialistaById(@PathVariable("id") Long id);
}