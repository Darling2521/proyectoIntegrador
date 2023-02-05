package fichaPaciente.api_ficha.ocupacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcupacionService {
    @Autowired
    OcupacionRepository ocupacionRepository;

    public Ocupacion save(Ocupacion entity) {
        return ocupacionRepository.save(entity);
    }

    public Ocupacion findById(Long id) {
        return ocupacionRepository.findById(id).orElse(new Ocupacion());
    }

    public void deleteById(Long id) {
        ocupacionRepository.deleteById(id);
    }

    public List<Ocupacion> findAll() {
        return ocupacionRepository.findAll();
    }

}
