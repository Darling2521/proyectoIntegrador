package bienestar.bffweb.agenda.citasagendadas;

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
@RequestMapping("api/citasagendadas")
@CrossOrigin({
        "*"
    })
@Tag(name = "Controlador de citas agendadas")
public class CitasAgendadasController {
    @Autowired
    CitasAgendadasClient client;

    @Operation(summary = "Obtiene todos las  citas agendada")
    @GetMapping("/")
    public List<CitasAgendadasDTO> findAll() {
        return client.findAll();
        }
@Operation(summary = "Obtiene citas agendadas por medio del id")
    @GetMapping("/{id}/")
    public CitasAgendadasDTO findById(@PathVariable Long id) {
        return client.findById(id);
        }
        @Operation(summary = "Registrar una nuevo cita agendada")
    @PostMapping("/")
    public CitasAgendadasDTO save(@RequestBody CitasAgendadasDTO entity) {
        return client.save(entity);
        }
        @Operation(summary = "Elimina un citas agendadas por id")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        client.deleteById(id);
        }
        @Operation(summary = "Actualiza citas agendadas por id")
    @PutMapping("/{id}/")
    public CitasAgendadasDTO update(@PathVariable Long id, @RequestBody CitasAgendadasDTO entity) {
        return client.update(id, entity);
        }
    @Operation(summary = "Actualización parcial de citas agendadas")
    @PatchMapping("/{id}/")
    public CitasAgendadasDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

    CitasAgendadasDTO CitasAgendadasDTO = client.findById(id);

    // itera sobre los campos que se desean actualizar
    for (Map.Entry<String, Object> field : fields.entrySet()) {
        String fieldName = field.getKey();
        Object fieldValue = field.getValue();

    // utiliza reflection para establecer el valor del campo en la entidad
    try {
        Field campoEntidad = CitasAgendadasDTO.class.getDeclaredField(fieldName);
        campoEntidad.setAccessible(true);
        campoEntidad.set(CitasAgendadasDTO, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException ex) {
    // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, CitasAgendadasDTO);
    }
    }