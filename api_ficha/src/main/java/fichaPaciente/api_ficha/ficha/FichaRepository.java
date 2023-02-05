package fichaPaciente.api_ficha.ficha;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FichaRepository extends CrudRepository<Ficha, Long> {

    List<Ficha> findAll();
}
