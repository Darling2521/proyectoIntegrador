package catalogo.api_catalogo.tratamiento;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TratamientoRepository extends CrudRepository<Tratamiento, Long>{

    List<Tratamiento> findAll();

}
