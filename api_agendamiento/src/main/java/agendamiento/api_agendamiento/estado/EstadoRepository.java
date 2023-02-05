package agendamiento.api_agendamiento.estado;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    List<Estado> findAll();

}
