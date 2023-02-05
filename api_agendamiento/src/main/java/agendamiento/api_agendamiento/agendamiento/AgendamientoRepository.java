package agendamiento.api_agendamiento.agendamiento;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AgendamientoRepository extends CrudRepository<Agendamiento, Long> {

    List<Agendamiento> findAll();

}
