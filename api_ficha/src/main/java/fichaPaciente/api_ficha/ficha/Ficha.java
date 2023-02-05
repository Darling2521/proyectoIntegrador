package fichaPaciente.api_ficha.ficha;

import fichaPaciente.api_ficha.ciudad.Ciudad;

//import java.util.ArrayList;
//import java.util.List;

 import fichaPaciente.api_ficha.genero.Genero;
 import fichaPaciente.api_ficha.ocupacion.Ocupacion;
 import fichaPaciente.api_ficha.tiposangre.TipoSangre;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pacienteId;
    private String alergia;
    private String enfermedad;
    private String discapacidad;
    // private Long generoId;
    // private Long ocupacionId;
    // private Long tiposangreId;
    // private Long ciudadId;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "ficha_id")
    // private List<DetalleFicha> detalle = new ArrayList<>();

     @OneToOne
     private Genero genero;

     @OneToOne
     private Ocupacion ocupacion;

     @OneToOne
     private TipoSangre tiposangre;

     @OneToOne
     private Ciudad ciudad;


    
    
}
