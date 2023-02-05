package bienestar.bffweb.atencion;

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
@RequestMapping("api/atencion")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de atencion")
public class AtencionController {
    @Autowired
    AtencionClient client;
    @Operation(summary = "Obtiene todos las Atenciones de la tabla atencion")
    @GetMapping("/")
    public List<AtencionDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene Atenciones por medio del id")
    @GetMapping("/{id}/")
    public AtencionDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
        @Operation(summary = "Registra una nuevo atencion")
    @PostMapping("/")
    public AtencionDTO save(@RequestBody AtencionDTO entity) {
        return client.save(entity);
        }
        @Operation(summary = "Elimina una atencion por medio del id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
        @Operation(summary = "Actualiza una atencion por id")
    @PutMapping("/{id}/")
    public AtencionDTO update(@PathVariable Long id, @RequestBody AtencionDTO entity) {
        return client.update(id, entity);
        }
        @Operation(summary = "Actualización parcial de atencion")
    @PatchMapping("/{id}/")
    public AtencionDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    AtencionDTO AtencionDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = AtencionDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(AtencionDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, AtencionDTO);
    }
    }