package atencion.api_atencion.atencion;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AtencionRepository extends CrudRepository<Atencion, Long> {

    List<Atencion> findAll();
}
