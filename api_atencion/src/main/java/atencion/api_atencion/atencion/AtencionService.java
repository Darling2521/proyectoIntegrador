package atencion.api_atencion.atencion;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ResourceUtils;

import atencion.api_atencion.diagnostico.DiagnosticoClient;
import atencion.api_atencion.diagnostico.DiagnosticoDTO;
import atencion.api_atencion.especialista.EspecialistaClient;
import atencion.api_atencion.especialista.EspecialistaDTO;
import atencion.api_atencion.paciente.PacienteClient;
import atencion.api_atencion.paciente.PacienteDTO;
import atencion.api_atencion.sintoma.Sintoma;
import atencion.api_atencion.tratamiento.Tratamiento;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtencionService {
    @Autowired
    AtencionRepository atencionRepository;
    
    @Autowired
    PacienteClient pacienteClient;
    
    @Autowired
    EspecialistaClient especialistaClient;
    
    @Autowired
    DiagnosticoClient diagnosticoClient;

    public Atencion save(Atencion entity) {
        return atencionRepository.save(entity);
    }

    public Atencion findById(Long id) {
        return atencionRepository.findById(id).orElse(new Atencion());
    }

    public void deleteById(Long id) {
        atencionRepository.deleteById(id);
    }

    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }
    
    public JasperPrint getAtencionReporte(Long id) {

        Map<String, Object> reportParameters = new HashMap<String, Object>();
        Atencion atencion = findById(id);
        if (atencion.getId() == null)
            return null;

        reportParameters.put("nro", atencion.getNro());
        reportParameters.put("fecha", Date.valueOf(atencion.getFecha()));

        PacienteDTO paciente = pacienteClient.findPacienteById(atencion.getPacienteId());
        reportParameters.put("nombre_paciente", paciente.getNombre());
        EspecialistaDTO especialista = especialistaClient.findEspecialistaById(atencion.getEspecialistaId());
        reportParameters.put("nombre_especialista", especialista.getNombre());
        DiagnosticoDTO diagnostico = diagnosticoClient.findDiagnosticoById(atencion.getDiagnosticoId());
        reportParameters.put("descripcion", diagnostico.getDescripcion());
       

        List<Map<String, Object>> dataList = new ArrayList<>();

         for (Sintoma sintoma : atencion.getSintoma()) {
             Map<String, Object> data = new HashMap<>();
            data.put("nombre", sintoma.getNombre());
            dataList.add(data);
         }
         reportParameters.put("sintomas", new JRBeanCollectionDataSource(dataList));

        List<Map<String, Object>> dataLista = new ArrayList<>();

        for (Tratamiento tratamiento : atencion.getTratamiento()) {
            Map<String, Object> data = new HashMap<>();
            data.put("terapia", tratamiento.getTerapia());
            dataLista.add(data);
        }
        reportParameters.put("tratamiento", new JRBeanCollectionDataSource(dataLista));

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/Atencion.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }

}
