package agendamiento.api_agendamiento.estado;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    public Estado save(Estado entity) {
        return estadoRepository.save(entity);
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id).orElse(new Estado());
    }

    public void deleteById(Long id) {
        estadoRepository.deleteById(id);
    }

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }
}