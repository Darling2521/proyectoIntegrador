package fichaPaciente.api_ficha.genero;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GeneroRepository extends CrudRepository<Genero, Long> {

    List<Genero> findAll();
}
