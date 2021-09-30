package falconi.rafael.kruger.resources;

import falconi.rafael.kruger.controller.EmployeeController;
import falconi.rafael.kruger.dtos.EmployeeDto;
import falconi.rafael.kruger.entities.Vaccine;
import falconi.rafael.kruger.resources.exception.DateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(EmployeeResource.EMPLOYEE)
public class EmployeeResource {
    public static final String EMPLOYEE = "/employee";
    public static final String VACCINATED = "/vaccinated/{vaccinated}";
    public static final String VACCINE = "/vaccine/{vaccine}";
    public static final String DATE = "/startDate";

    private final EmployeeController employeeController;

    @Autowired
    public EmployeeResource(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @PostMapping
    public ResponseEntity<Object> registerEmployee(@Valid @RequestBody EmployeeDto employee) {
        this.employeeController.registerEmployee(employee);
        return new ResponseEntity<>("\"Empleado registrado\"", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = EmployeeResource.VACCINATED)
    public List<EmployeeDto> getEmployeeByVaccinated(@PathVariable boolean vaccinated) {
        return this.employeeController.getEmployeeByVaccinated(vaccinated);
    }

    @GetMapping(value = EmployeeResource.VACCINE)
    public List<EmployeeDto> getEmployeeByVaccine(@PathVariable String vaccine) {
        Vaccine vaccine1 = Vaccine.valueOf(vaccine);
        return this.employeeController.getEmployeeByVaccine(vaccine1);
    }

    @GetMapping(value = EmployeeResource.DATE)
    public List<EmployeeDto> getEmployeeByDate(@RequestParam String dateStart, @RequestParam String dateEnd) throws DateException {
        try {
             return this.employeeController.getEmployeeByDate(dateStart, dateEnd);
             //return dateStart+" "+dateStart;
        } catch (Exception e) {
            throw new DateException("las fechas no estan en el formato correcto");
        }

    }
}
