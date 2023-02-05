package catalogo.api_catalogo.diagnostico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoService {
    @Autowired
    DiagnosticoRepository diagnosticoRepository;

    public Diagnostico save(Diagnostico entity) {
        return diagnosticoRepository.save(entity);
    }

    public Diagnostico findById(Long id) {
        return diagnosticoRepository.findById(id).orElse(new Diagnostico());
    }

    public void deleteById(Long id) {
        diagnosticoRepository.deleteById(id);
    }

    public List<Diagnostico> findAll() {
        return diagnosticoRepository.findAll();
    }
}