package bienestar.bffweb.fichaPaciente.ocupacion;

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
@RequestMapping("api/ocupacion")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de ocupación")

public class OcupacionController {
    @Autowired
    OcupacionClient client;
    @Operation(summary = "Obtiene la ocupacion que tienen en el institiuto los pacientes")
    @GetMapping("/")
    public List<OcupacionDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene una ocupación por el id")
    @GetMapping("/{id}/")
    public OcupacionDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra una nueva ocuapación")
    @PostMapping("/")
    public OcupacionDTO save(@RequestBody OcupacionDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina ocupación mediante el id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza ocupación mediante el id")
    @PutMapping("/{id}/")
    public OcupacionDTO update(@PathVariable Long id, @RequestBody OcupacionDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de ocupación")
    @PatchMapping("/{id}/")
    public OcupacionDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    OcupacionDTO OcupacionDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = OcupacionDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(OcupacionDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, OcupacionDTO);
    }
    }
