package bienestar.bffweb.agenda.agendamiento;

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
@RequestMapping("api/agendamiento")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de agendamiento")

public class AgendamientoController {
    @Autowired
    AgendamientoClient client;
    @Operation(summary = "Obtiene todos los citasreservadas de la tabla agendamiento")
    @GetMapping("/")
    public List<AgendamientoDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene agendamientos por medio del id")
    @GetMapping("/{id}/")
    public AgendamientoDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registrar un nuevo agendamiento")
    @PostMapping("/")
    public AgendamientoDTO save(@RequestBody AgendamientoDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina un agendamiento por id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza agendamiento por id")
    @PutMapping("/{id}/")
    public AgendamientoDTO update(@PathVariable Long id, @RequestBody AgendamientoDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de agendamiento")
    @PatchMapping("/{id}/")
    public AgendamientoDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    AgendamientoDTO AgendamientoDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = AgendamientoDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(AgendamientoDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, AgendamientoDTO);
    }
    }