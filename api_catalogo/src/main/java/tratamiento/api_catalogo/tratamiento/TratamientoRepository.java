package tratamiento.api_catalogo.tratamiento;
import java.util.List;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
        public List<Tratamiento> findAll();
       
       }
