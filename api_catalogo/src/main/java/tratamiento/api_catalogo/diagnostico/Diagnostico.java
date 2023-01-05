package tratamiento.api_catalogo.diagnostico;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Diagnostico {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id_diagnostico;
 private String diagnostico;
 private Long id_sintomas;
}