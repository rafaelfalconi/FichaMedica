package falconi.rafael.kruger.repositories;

import falconi.rafael.kruger.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, String> {

    Optional<MedicalRecord> findMedicalRecordByEmployee_Id(String id);


}
