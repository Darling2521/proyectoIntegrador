package atencion.api_atencion.sintoma;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomaService {
    @Autowired
    SintomaRepository entityRepository;

    public Sintoma save(Sintoma entity) {
        return entityRepository.save(entity);
    }

    public Sintoma findById(Long id) {
        return entityRepository.findById(id).orElse(new Sintoma());
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

    public List<Sintoma> findAll() {
        return entityRepository.findAll();
    }
}
