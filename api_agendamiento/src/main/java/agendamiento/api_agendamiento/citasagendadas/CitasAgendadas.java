package agendamiento.api_agendamiento.citasagendadas;

import agendamiento.api_agendamiento.estado.Estado;
import agendamiento.api_agendamiento.agendamiento.Agendamiento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CitasAgendadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Agendamiento agendamiento;

    @ManyToOne
    private Estado estado;

}
