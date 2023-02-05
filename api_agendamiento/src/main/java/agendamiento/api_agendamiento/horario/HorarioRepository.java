package agendamiento.api_agendamiento.horario;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

    List<Horario> findAll();

}
