package tratamiento.api_catalogo.sintomas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomasService {
    @Autowired SintomasRepository sintomasRepository;
    public Sintomas save(Sintomas entity){
        return sintomasRepository.save(entity);
        }
        public Sintomas findById( Long id){
        return sintomasRepository.findById(id).orElse(new Sintomas());
        }
        public void deleteById(Long id){
        sintomasRepository.deleteById(id);
        }
        public List<Sintomas> findAll(){
        return sintomasRepository.findAll();
        }   
}
