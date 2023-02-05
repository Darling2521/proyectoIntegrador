package atencion.api_atencion.tratamiento;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TratamientoRepository extends CrudRepository<Tratamiento, Long> {

    public List<Tratamiento> findAll();
}
