package agendamiento.api_agendamiento.agendamiento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamientoService {
    @Autowired
    AgendamientoRepository agendamientoRepository;

    public Agendamiento save(Agendamiento entity) {
        return agendamientoRepository.save(entity);
    }

    public Agendamiento findById(Long id) {
        return agendamientoRepository.findById(id).orElse(new Agendamiento());
    }

    public void deleteById(Long id) {
        agendamientoRepository.deleteById(id);
    }

    public List<Agendamiento> findAll() {
        return agendamientoRepository.findAll();
    }
}