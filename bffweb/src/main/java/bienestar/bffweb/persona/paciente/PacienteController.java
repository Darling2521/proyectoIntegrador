package bienestar.bffweb.persona.paciente;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/paciente")
@CrossOrigin({ "*" })
@Tag(name = "Controlador del paciente")

public class PacienteController {
    @Autowired
    PacienteClient client;
    
    @Operation(summary = "Obtiene todos los pacientes registrados en este microservicio")

    @GetMapping("/")
    public List<PacienteDTO> findAll() {
        return client.findAll();
    }

    @Operation(summary = "Obtiene un paciente mediante el id")
    @GetMapping("/{id}/")
    public PacienteDTO findById(@PathVariable Long id) {
        return client.findById(id);
    }
    @Operation(summary = "Registro del paciente")
    @PostMapping("/")
    public PacienteDTO save(@RequestBody PacienteDTO entity) {
        return client.save(entity);
    }
    @Operation(summary = "Elimina paciente mediante id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
    }
    @Operation(summary = "Actualiza un paciente mediante id")
    @PutMapping("/{id}/")
    public PacienteDTO update(@PathVariable Long id, @RequestBody PacienteDTO entity) {
        return client.update(id, entity);

    }
    @Operation(summary = "Actualización parcial de paciente")
    @PatchMapping("/{id}/")
    public PacienteDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

        PacienteDTO PacienteDTO = client.findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
         String fieldName = field.getKey();
           Object fieldValue = field.getValue();

            // utiliza reflection para establecer el valor del campo en la entidad
           try {
           Field campoEntidad = PacienteDTO.class.getDeclaredField(fieldName);
           campoEntidad.setAccessible(true);
            campoEntidad.set(PacienteDTO, fieldValue);
             } catch (NoSuchFieldException | IllegalAccessException ex) {
            // maneja la excepción si ocurre algún error al acceder al campo
            }
             }
            return client.update(id, PacienteDTO);
        }
    }

