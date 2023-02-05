package bienestar.bffweb.catalogo.diagnostico;

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
@RequestMapping("api/diagnostico")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de diagnostico")
public class DiagnosticoController {
    @Autowired
    DiagnosticoClient client;
    @Operation(summary = "Obtiene todos los diagnosticos de la tabla diagnostico")
    @GetMapping("/")
    public List<DiagnosticoDTO> findAll() {
        return client.findAll();
        }
    @Operation(summary = "Obtiene diagnosticos por medio del id")
    @GetMapping("/{id}/")
    public DiagnosticoDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
    @Operation(summary = "Registra un nuevo diagnostico")
    @PostMapping("/")
    public DiagnosticoDTO save(@RequestBody DiagnosticoDTO entity) {
        return client.save(entity);
        }
    @Operation(summary = "Elimina diagnostico por medio del id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
    @Operation(summary = "Actualiza diagnostico por id")
    @PutMapping("/{id}/")
    public DiagnosticoDTO update(@PathVariable Long id, @RequestBody DiagnosticoDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de diagnostico")
    @PatchMapping("/{id}/")
    public DiagnosticoDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    DiagnosticoDTO DiagnosticoDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = DiagnosticoDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(DiagnosticoDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, DiagnosticoDTO);
    }
    }
