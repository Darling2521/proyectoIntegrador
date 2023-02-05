package bienestar.bffweb.fichaPaciente.genero;

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
@RequestMapping("api/genero")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de genero")

public class GeneroController {
    @Autowired
    GeneroClient client;
    @Operation(summary = "Obtiene todos los generos del microservicio ficha")
    @GetMapping("/")
    public List<GeneroDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene generos mediante el id")
    @GetMapping("/{id}/")
    public GeneroDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra un nuevo genero")
    @PostMapping("/")
    public GeneroDTO save(@RequestBody GeneroDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina genero mediante el id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza un genero por id")
    @PutMapping("/{id}/")
    public GeneroDTO update(@PathVariable Long id, @RequestBody GeneroDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de genero")
    @PatchMapping("/{id}/")
    public GeneroDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    GeneroDTO GeneroDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = GeneroDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(GeneroDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, GeneroDTO);
    }
    }