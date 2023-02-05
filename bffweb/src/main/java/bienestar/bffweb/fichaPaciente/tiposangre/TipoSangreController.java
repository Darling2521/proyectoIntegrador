package bienestar.bffweb.fichaPaciente.tiposangre;

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
@RequestMapping("api/tiposangre")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de tipo sangre")

public class TipoSangreController {
    @Autowired
    TipoSangreClient client;
    @Operation(summary = "Obtiene todos los tipos de sangre")
    @GetMapping("/")
    public List<TipoSangreDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene un tipo de sangre por id")
    @GetMapping("/{id}/")
    public TipoSangreDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra un nuevo tipo de sangre")
    @PostMapping("/")
    public TipoSangreDTO save(@RequestBody TipoSangreDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina tipos de sangre por medio del id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualización de tipo sangre por medio de id")
    @PutMapping("/{id}/")
    public TipoSangreDTO update(@PathVariable Long id, @RequestBody TipoSangreDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de tipo sangre")
    @PatchMapping("/{id}/")
    public TipoSangreDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    TipoSangreDTO TipoSangreDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = TipoSangreDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(TipoSangreDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, TipoSangreDTO);
    }
    }
