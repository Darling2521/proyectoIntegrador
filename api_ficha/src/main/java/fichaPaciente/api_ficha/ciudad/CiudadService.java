package fichaPaciente.api_ficha.ciudad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {
    @Autowired
    CiudadRepository ciudadRepository;

    public Ciudad save(Ciudad entity) {
        return ciudadRepository.save(entity);
    }

    public Ciudad findById(Long id) {
        return ciudadRepository.findById(id).orElse(new Ciudad());
    }

    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }

    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

}