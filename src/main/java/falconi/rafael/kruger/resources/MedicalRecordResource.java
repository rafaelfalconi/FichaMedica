package falconi.rafael.kruger.resources;

import falconi.rafael.kruger.controller.MedicalRecordController;
import falconi.rafael.kruger.dtos.MedicalRecordDto;
import falconi.rafael.kruger.resources.exception.DateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = MedicalRecordResource.MEDICALRECORD)
public class MedicalRecordResource {
    public static final String MEDICALRECORD = "/medical-record";
    public static final String ID = "/{id}";
    private MedicalRecordController medicalRecordController;

    @Autowired
    public MedicalRecordResource(MedicalRecordController medicalRecordController) {
        this.medicalRecordController = medicalRecordController;
    }

    @PatchMapping(value = ID)
    public ResponseEntity<Object> updateMedicalRecord(@PathVariable String id, @Valid @RequestBody MedicalRecordDto medicalRecordDto) throws DateException {
        try {
            if (this.medicalRecordController.updateMedicalRecord(id, medicalRecordDto))
                return new ResponseEntity<Object>("\"Datos actualizados\"", HttpStatus.ACCEPTED);
            return new ResponseEntity<Object>("\"Los Datos enviados no son correctos\"", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new DateException("las fechas no estan en el formato correcto");
        }
    }
}
