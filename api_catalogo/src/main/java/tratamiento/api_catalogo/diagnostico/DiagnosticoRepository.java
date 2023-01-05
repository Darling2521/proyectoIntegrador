package tratamiento.api_catalogo.diagnostico;
import java.util.List;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
        public List<Diagnostico> findAll();
       
       }
