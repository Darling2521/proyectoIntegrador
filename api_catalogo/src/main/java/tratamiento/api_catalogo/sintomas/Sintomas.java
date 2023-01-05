package tratamiento.api_catalogo.sintomas;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Sintomas {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id_sintomas;
 private String alergias;
 private String antecedente_psiquiatrico;
 private String antecedente_patologico; 
}