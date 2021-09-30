package falconi.rafael.kruger.controller;

import falconi.rafael.kruger.dtos.MedicalRecordDto;
import falconi.rafael.kruger.entities.MedicalRecord;
import falconi.rafael.kruger.repositories.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class MedicalRecordController {

    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    public MedicalRecordController(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public boolean updateMedicalRecord(String employee_id, MedicalRecordDto medicalRecord) throws ParseException {
        Optional<MedicalRecord> medicalRecordOptional = this.medicalRecordRepository.findMedicalRecordByEmployee_Id(employee_id);
        if (!medicalRecordOptional.isPresent()) return false;
        java.sql.Date birthDateSql = this.getDate(medicalRecord.getBirthDate());
        MedicalRecord medicalRecordDb = medicalRecordOptional.get();
        medicalRecordDb.setBirthDate(birthDateSql);
        medicalRecordDb.setAddress(medicalRecord.getAddress());
        medicalRecordDb.setPhone(medicalRecord.getPhone());
        if (medicalRecord.isVaccinated()) {
            medicalRecordDb.setVaccinated(medicalRecord.isVaccinated());
            java.sql.Date vaccineDateSql = this.getDate(medicalRecord.getVaccineDate());
            medicalRecordDb.setVaccineDate(vaccineDateSql);
            medicalRecordDb.setVaccine(medicalRecord.getVaccine());
            medicalRecordDb.setDose(medicalRecord.getDose());

        }
        this.medicalRecordRepository.save(medicalRecordDb);
        return true;
    }

    private java.sql.Date getDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date vaccineDate = format.parse(date);
        java.sql.Date dateSql = new java.sql.Date(vaccineDate.getTime());
        return dateSql;
    }
}
