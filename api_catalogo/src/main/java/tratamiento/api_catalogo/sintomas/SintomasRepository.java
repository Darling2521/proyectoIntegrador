package tratamiento.api_catalogo.sintomas;
import java.util.List;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface SintomasRepository extends JpaRepository<Sintomas, Long> {
        public List<Sintomas> findAll();
       
       }
