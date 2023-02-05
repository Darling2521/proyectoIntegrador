package catalogo.api_catalogo.sintoma;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SintomaRepository extends CrudRepository<Sintoma, Long> {

    List<Sintoma> findAll();

}