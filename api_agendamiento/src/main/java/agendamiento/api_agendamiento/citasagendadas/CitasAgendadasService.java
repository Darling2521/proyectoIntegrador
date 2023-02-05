package agendamiento.api_agendamiento.citasagendadas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitasAgendadasService {
    @Autowired
    CitasAgendadasRepository citasAgendadasRepository;

    public CitasAgendadas save(CitasAgendadas entity) {
        return citasAgendadasRepository.save(entity);
    }

    public CitasAgendadas findById(Long id) {
        return citasAgendadasRepository.findById(id).orElse(new CitasAgendadas());
    }

    public void deleteById(Long id) {
        citasAgendadasRepository.deleteById(id);
    }

    public List<CitasAgendadas> findAll() {
        return citasAgendadasRepository.findAll();
    }
}