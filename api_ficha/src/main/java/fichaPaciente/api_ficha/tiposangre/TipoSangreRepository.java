package fichaPaciente.api_ficha.tiposangre;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TipoSangreRepository extends CrudRepository<TipoSangre, Long> {

    List<TipoSangre> findAll();
}
