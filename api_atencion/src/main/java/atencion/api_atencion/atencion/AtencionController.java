package atencion.api_atencion.atencion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/atencion")
@CrossOrigin({ "*" })
public class AtencionController {
    @Autowired
    AtencionService atencionService;

    @GetMapping("/")
    public List<Atencion> findAll() {
        return atencionService.findAll();
    }

    @GetMapping("/{id}/")
    public Atencion findById(@PathVariable Long id) {
        return atencionService.findById(id);
    }

    @PostMapping("/")
    public Atencion save(@RequestBody Atencion entity) {
        return atencionService.save(entity);
    }

    @PutMapping("/{id}/")
    public Atencion update(@RequestBody Atencion entity) {
        return atencionService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        atencionService.deleteById(id);
    }

    @GetMapping("/pdf/{id}/")
    public ResponseEntity<byte[]> getAtencionReporte(@PathVariable long id) throws JRException {

        JasperPrint reporte = atencionService.getAtencionReporte(id);

        if (reporte == null)
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);

        HttpHeaders headers = new HttpHeaders();
        // set the PDF format
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "atencion.pdf");
        // create the report in PDF format
        return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);

    }

}
