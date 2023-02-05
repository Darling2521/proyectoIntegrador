package bienestar.bffweb.fichaPaciente.ficha;

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
@RequestMapping("api/ficha")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de la ficha")

public class FichaController {
    @Autowired
    FichaClient client;
    @Operation(summary = "Obtiene todos las fichas registradas")
    @GetMapping("/")
    public List<FichaDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene fichas mediante el id")
    @GetMapping("/{id}/")
    public FichaDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
     @Operation(summary = "Registra nuevas fichas")
    @PostMapping("/")
    public FichaDTO save(@RequestBody FichaDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina Ficha mediante el id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza ficha mediante el id")
    @PutMapping("/{id}/")
    public FichaDTO update(@PathVariable Long id, @RequestBody FichaDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización pparcial de ficha")
    @PatchMapping("/{id}/")
    public FichaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    FichaDTO FichaDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = FichaDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(FichaDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, FichaDTO);
    }
    }
