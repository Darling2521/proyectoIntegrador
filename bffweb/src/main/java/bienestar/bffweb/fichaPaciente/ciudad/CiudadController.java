package bienestar.bffweb.fichaPaciente.ciudad;

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
@RequestMapping("api/ciudad")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de ciudad")

public class CiudadController {
    @Autowired
    CiudadClient client;

    
    @Operation(summary = "Obtiene todos las ciudades registradas")

    @GetMapping("/")
    public List<CiudadDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene ciudades por id")
    @GetMapping("/{id}/")
    public CiudadDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra ciudades")
    @PostMapping("/")
    public CiudadDTO save(@RequestBody CiudadDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina mediante el id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualizacion de ciudad")
    @PutMapping("/{id}/")
    public CiudadDTO update(@PathVariable Long id, @RequestBody CiudadDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualizacion parcial de ciudad")
    @PatchMapping("/{id}/")
    public CiudadDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    CiudadDTO CiudadDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = CiudadDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(CiudadDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, CiudadDTO);
    }
    }