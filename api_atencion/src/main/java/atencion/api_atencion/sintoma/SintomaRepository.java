package atencion.api_atencion.sintoma;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SintomaRepository extends CrudRepository<Sintoma, Long> {

    public List<Sintoma> findAll();
}

