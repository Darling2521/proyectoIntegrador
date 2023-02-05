package fichaPaciente.api_ficha.ficha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaService {
    @Autowired
   FichaRepository fichaRepository;
    
    public Ficha save(Ficha entity) {
        return fichaRepository.save(entity);
    }

    public Ficha findById(Long id) {
        return fichaRepository.findById(id).orElse(new Ficha());
    }

    public void deleteById(Long id) {
        fichaRepository.deleteById(id);
    }

    public List<Ficha> findAll() {
        return fichaRepository.findAll();
    }

}
