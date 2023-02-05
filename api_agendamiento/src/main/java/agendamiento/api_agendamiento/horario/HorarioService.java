package agendamiento.api_agendamiento.horario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository horarioRepository;

    public Horario save(Horario entity) {
        return horarioRepository.save(entity);
    }

    public Horario findById(Long id) {
        return horarioRepository.findById(id).orElse(new Horario());
    }

    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }

    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }
}