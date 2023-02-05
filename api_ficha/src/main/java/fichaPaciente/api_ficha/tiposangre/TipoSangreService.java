package fichaPaciente.api_ficha.tiposangre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSangreService {
    @Autowired
    TipoSangreRepository tipoSangreRepository;

    public TipoSangre save(TipoSangre entity) {
        return tipoSangreRepository.save(entity);
    }

    public TipoSangre findById(Long id) {
        return tipoSangreRepository.findById(id).orElse(new TipoSangre());
    }

    public void deleteById(Long id) {
        tipoSangreRepository.deleteById(id);
    }

    public List<TipoSangre> findAll() {
        return tipoSangreRepository.findAll();
    }

}