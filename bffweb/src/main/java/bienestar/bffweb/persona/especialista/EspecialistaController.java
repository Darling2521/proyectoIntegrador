package bienestar.bffweb.persona.especialista;

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
@RequestMapping("api/especialista")
@CrossOrigin({ "*" })
@Tag(name = "Controlador del especialista")

public class EspecialistaController {
    @Autowired
    EspecialistaClient client;
    
    @Operation(summary = "Obtiene todos los especialistas registrados en este microservicio")
    @GetMapping("/")
    public List<EspecialistaDTO> findAll() {
        return client.findAll();
        }
    
    @Operation(summary = "Obtiene un especialista mediante el id")
    @GetMapping("/{id}/")
    public EspecialistaDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra especialistas")    
    @PostMapping("/")
    public EspecialistaDTO save(@RequestBody EspecialistaDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina especialista por id")  
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza especialista mediante id")  
    @PutMapping("/{id}/")
    public EspecialistaDTO update(@PathVariable Long id, @RequestBody EspecialistaDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial ") 
    @PatchMapping("/{id}/")
    public EspecialistaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    EspecialistaDTO EspecialistaDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = EspecialistaDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(EspecialistaDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, EspecialistaDTO);
    }
    }