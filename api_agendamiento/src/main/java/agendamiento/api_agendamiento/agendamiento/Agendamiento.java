package agendamiento.api_agendamiento.agendamiento;


//import agendamiento.api_agendamiento.estado.Estado;
import agendamiento.api_agendamiento.horario.Horario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Agendamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pacienteId;

    @ManyToOne
    private Horario horario;
    
    // @ManyToOne
    // private Estado estado;
   
    

}