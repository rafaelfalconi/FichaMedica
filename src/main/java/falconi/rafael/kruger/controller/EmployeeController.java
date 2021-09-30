package falconi.rafael.kruger.controller;

import falconi.rafael.kruger.entities.Employee;
import falconi.rafael.kruger.entities.MedicalRecord;
import falconi.rafael.kruger.repositories.EmployeeRepository;
import falconi.rafael.kruger.repositories.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, MedicalRecordRepository medicalRecordRepository) {
        this.employeeRepository = employeeRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }





    public void registedEmployee(Employee employee) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setEmployee(employee);
        employee.setMedicalRecord(medicalRecord);
        this.employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeByVaccinated(boolean vaccinated) {
        return this.employeeRepository.findEmployeesByMedicalRecord_Vaccinated(vaccinated);
    }

    public List<Employee> getEmployeeByVaccine(Enum vaccine) {
        return this.employeeRepository.findEmployeesByMedicalRecord_Vaccine(vaccine);
    }

    public List<Employee> getEmployeeByDate(String dateStart, String dateEnd) throws Exception{
        Date startDate = this.getDate(dateStart);
        Date endDate = this.getDate(dateEnd);
        return this.employeeRepository.findEmployeesByMedicalRecord_VaccineDateIsBetween(startDate,endDate);
    }

    protected java.sql.Date getDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date vaccineDate = format.parse(date);
        java.sql.Date dateSql = new java.sql.Date(vaccineDate.getTime());
        return dateSql;
    }
}
