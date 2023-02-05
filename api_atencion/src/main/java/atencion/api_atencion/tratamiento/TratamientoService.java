package atencion.api_atencion.tratamiento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoService {
    @Autowired
    TratamientoRepository entityRepository;

    public Tratamiento save(Tratamiento entity) {
        return entityRepository.save(entity);
    }

    public Tratamiento findById(Long id) {
        return entityRepository.findById(id).orElse(new Tratamiento());
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

    public List<Tratamiento> findAll() {
        return entityRepository.findAll();
    }
}
