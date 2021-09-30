package falconi.rafael.kruger.repositories;

import falconi.rafael.kruger.entities.Employee;
import falconi.rafael.kruger.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findEmployeesByMedicalRecord_Vaccinated(boolean vaccinated);

    List<Employee> findEmployeesByMedicalRecord_Vaccine(Enum vaccine);

    List<Employee> findEmployeesByMedicalRecord_VaccineDateIsBetween(Date dateStart, Date dateEnd);
}
