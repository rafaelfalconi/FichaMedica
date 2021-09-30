package falconi.rafael.kruger.dtos;

import falconi.rafael.kruger.entities.Employee;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto {

    @Size(min = 10, max = 10, message = "La cédula es de 10 digitos")
    private String ci;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Email invalido")
    private String email;

    @Pattern(regexp = "^[A-Za-z]*$", message = "{validation.name.notNumbers}")
    private String lastName;

    @Pattern(regexp = "^[A-Za-z]*$", message = "{validation.name.notNumbers}")
    private String name;

    public EmployeeDto() {
    }

    public EmployeeDto(String ci, String email, String lastName, String name) {
        this.ci = ci;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
    }

    public EmployeeDto(Employee employee) {
        this.ci = employee.getCi();
        this.email = employee.getEmail();
        this.lastName = employee.getLastName();
        this.name = employee.getName();
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
