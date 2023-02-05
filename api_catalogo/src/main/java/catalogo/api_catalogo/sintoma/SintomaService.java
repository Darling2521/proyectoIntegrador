package catalogo.api_catalogo.sintoma;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomaService {
    @Autowired
    SintomaRepository sintomaRepository;

    public Sintoma save(Sintoma entity) {
        return sintomaRepository.save(entity);
    }

    public Sintoma findById(Long id) {
        return sintomaRepository.findById(id).orElse(new Sintoma());
    }

    public void deleteById(Long id) {
        sintomaRepository.deleteById(id);
    }

    public List<Sintoma> findAll() {
        return sintomaRepository.findAll();
    }
}