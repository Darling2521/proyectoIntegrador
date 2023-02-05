package fichaPaciente.api_ficha.genero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    public Genero save(Genero entity) {
        return generoRepository.save(entity);
    }

    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(new Genero());
    }

    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

}
