package catalogo.api_catalogo.diagnostico;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosticoRepository extends CrudRepository<Diagnostico, Long> {

    List<Diagnostico> findAll();

}
