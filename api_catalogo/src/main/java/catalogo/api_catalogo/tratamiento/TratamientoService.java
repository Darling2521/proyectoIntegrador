package catalogo.api_catalogo.tratamiento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoService {
    @Autowired TratamientoRepository tratamientoRepository;

    public Tratamiento save(Tratamiento entity){
        return tratamientoRepository.save(entity);
    }

    public Tratamiento findById( Long id){
        return tratamientoRepository.findById(id).orElse(new Tratamiento());
    }

    public void deleteById(Long id){
        tratamientoRepository.deleteById(id);
    }

    public List<Tratamiento> findAll(){
        return tratamientoRepository.findAll();
    }
}
    

