package falconi.rafael.kruger.controller;

import falconi.rafael.kruger.dtos.EmployeeDto;
import falconi.rafael.kruger.entities.Employee;
import falconi.rafael.kruger.entities.MedicalRecord;
import falconi.rafael.kruger.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }


    public void registerEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setCi(employeeDto.getCi());
        employee.setEmail(employeeDto.getEmail());
        employee.setName(employee.getName());
        employee.setLastName(employeeDto.getLastName());
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setEmployee(employee);
        employee.setMedicalRecord(medicalRecord);
        this.employeeRepository.save(employee);
    }

    public List<EmployeeDto> getEmployeeByVaccinated(boolean vaccinated) {

        List<Employee> employees = this.employeeRepository.findEmployeesByMedicalRecord_Vaccinated(vaccinated);

        return this.transformToEmployeeDto(employees);
    }

    public List<EmployeeDto> getEmployeeByVaccine(Enum vaccine) {
        List<Employee> employees = this.employeeRepository.findEmployeesByMedicalRecord_Vaccine(vaccine);
        return this.transformToEmployeeDto(employees);
    }

    public List<EmployeeDto> getEmployeeByDate(String dateStart, String dateEnd) throws Exception {
        Date startDate = this.getDate(dateStart);
        Date endDate = this.getDate(dateEnd);
        List<Employee> employees = this.employeeRepository.findEmployeesByMedicalRecord_VaccineDateIsBetween(startDate, endDate);
        return this.transformToEmployeeDto(employees);
    }

    private java.sql.Date getDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date vaccineDate = format.parse(date);
        return new Date(vaccineDate.getTime());
    }

    private List<EmployeeDto> transformToEmployeeDto(List<Employee> employees) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee :
                employees) {
            EmployeeDto employeeDto = new EmployeeDto(employee);
            employeeDtoList.add(employeeDto);

        }
        return employeeDtoList;
    }
}
