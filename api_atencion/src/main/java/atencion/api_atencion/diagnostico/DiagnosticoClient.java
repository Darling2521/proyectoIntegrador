package atencion.api_atencion.diagnostico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "bff.diagnostico", url = "http://localhost:8082/api/diagnostico")
public interface DiagnosticoClient {
    @GetMapping("/{id}/")
    DiagnosticoDTO findDiagnosticoById(@PathVariable("id") Long id);
}
