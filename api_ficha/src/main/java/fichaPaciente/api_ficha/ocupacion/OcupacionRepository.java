package fichaPaciente.api_ficha.ocupacion;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OcupacionRepository extends CrudRepository<Ocupacion, Long> {

    List<Ocupacion> findAll();
}
