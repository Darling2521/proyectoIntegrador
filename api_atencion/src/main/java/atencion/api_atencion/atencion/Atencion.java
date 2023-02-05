package atencion.api_atencion.atencion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import atencion.api_atencion.sintoma.Sintoma;
import atencion.api_atencion.tratamiento.Tratamiento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nro;
    private LocalDate fecha;
    private Long pacienteId;
    private Long especialistaId;
    private Long diagnosticoId;

     @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "atencion_id")
     private List<Sintoma> sintoma = new ArrayList<>();

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "atencion_id")
    private List<Tratamiento> tratamiento = new ArrayList<>();
    
}
