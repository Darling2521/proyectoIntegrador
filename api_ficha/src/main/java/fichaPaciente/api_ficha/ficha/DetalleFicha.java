// package fichaPaciente.api_ficha.ficha;

// import fichaPaciente.api_ficha.ciudad.Ciudad;
// import fichaPaciente.api_ficha.genero.Genero;
// import fichaPaciente.api_ficha.ocupacion.Ocupacion;
// import fichaPaciente.api_ficha.tiposangre.TipoSangre;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import lombok.Data;

// @Data
// @Entity
// public class DetalleFicha {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Ciudad ciudad;
//     @ManyToOne
//     private TipoSangre tiposangre;
//     @ManyToOne
//     private Ocupacion ocupacion;
//     @ManyToOne
//     private Genero genero;
    
// }
