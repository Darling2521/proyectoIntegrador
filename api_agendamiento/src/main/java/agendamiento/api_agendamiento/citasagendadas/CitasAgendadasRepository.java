package agendamiento.api_agendamiento.citasagendadas;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CitasAgendadasRepository extends CrudRepository<CitasAgendadas, Long> {

    List<CitasAgendadas> findAll();

}
