package tratamiento.api_catalogo.tratamiento;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Tratamiento {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id_tratamiento;
 private String medicamento;
 private String dosis;
 private String frecuencia; 
 private String duracion; 
 private Long id_diagnostico; 
}