package falconi.rafael.kruger.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String address, phone;

    @Enumerated(EnumType.STRING)
    private Vaccine vaccine;

    private int dose;

    private boolean vaccinated;

    private Date birthDate, vaccineDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "fk_employee", updatable = false, nullable = false)
    private Employee employee;

    public MedicalRecord() {
    }

    public MedicalRecord(String id, String address, String phone, Vaccine vaccine, int dose, boolean vaccinated, Date birthDate, Date vaccineDate, Employee employee) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.vaccine = vaccine;
        this.dose = dose;
        this.vaccinated = vaccinated;
        this.birthDate = birthDate;
        this.vaccineDate = vaccineDate;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
