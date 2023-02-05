package bienestar.bffweb.agenda.horario;

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
@RequestMapping("api/horario")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de horario")
public class HorarioController {
    @Autowired
    HorarioClient client;

    @Operation(summary = "Obtiene todos los horarios de la tabla horario")
    @GetMapping("/")
    public List<HorarioDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene horarios por medio del id")
    @GetMapping("/{id}/")
    public HorarioDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registrar un nuevo horario")
    @PostMapping("/")
    public HorarioDTO save(@RequestBody HorarioDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina un horario por id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza horario por id")
    @PutMapping("/{id}/")
    public HorarioDTO update(@PathVariable Long id, @RequestBody HorarioDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de horario")
    @PatchMapping("/{id}/")
    public HorarioDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    HorarioDTO HorarioDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = HorarioDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(HorarioDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, HorarioDTO);
    }
    }
