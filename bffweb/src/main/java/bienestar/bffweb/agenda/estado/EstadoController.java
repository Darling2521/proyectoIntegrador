package bienestar.bffweb.agenda.estado;

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
@RequestMapping("api/estado")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de estado")
public class EstadoController {
    @Autowired
    EstadoClient client;
    
    @Operation(summary = "Obtiene todos lss  estados de las citas")
    @GetMapping("/")
    public List<EstadoDTO> findAll() {
        return client.findAll();
        }

    @Operation(summary = "Obtiene estados por medio del id")
    @GetMapping("/{id}/")
    public EstadoDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }

    @Operation(summary = "Registrar un nuevo estado")
    @PostMapping("/")
    public EstadoDTO save(@RequestBody EstadoDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina un estado por id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza estado por id")
    @PutMapping("/{id}/")
    public EstadoDTO update(@PathVariable Long id, @RequestBody EstadoDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de estado")
    @PatchMapping("/{id}/")
    public EstadoDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    EstadoDTO EstadoDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = EstadoDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(EstadoDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, EstadoDTO);
    }
    }