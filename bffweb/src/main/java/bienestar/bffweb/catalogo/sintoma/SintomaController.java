package bienestar.bffweb.catalogo.sintoma;

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
@RequestMapping("api/sintoma")
@CrossOrigin({
        "*"
    })
    @Tag(name = "Controlador de sintoma")
public class SintomaController {
    @Autowired
    SintomaClient client;
    @Operation(summary = "Obtiene todos los sintomas de la tabla sintoma")
    @GetMapping("/")
    public List<SintomaDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene sintomas por medio del id")
    @GetMapping("/{id}/")
    public SintomaDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra un nuevo sintoma")
    @PostMapping("/")
    public SintomaDTO save(@RequestBody SintomaDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina sintoma por medio del id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza sintoma por id")
    @PutMapping("/{id}/")
    public SintomaDTO update(@PathVariable Long id, @RequestBody SintomaDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualizaci??n parcial de sintoma")
    @PatchMapping("/{id}/")
    public SintomaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    SintomaDTO SintomaDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = SintomaDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(SintomaDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepci??n si ocurre alg??n error al acceder al campo
            }
        }
        return client.update(id, SintomaDTO);
    }
    }
