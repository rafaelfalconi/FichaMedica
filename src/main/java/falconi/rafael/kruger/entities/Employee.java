package falconi.rafael.kruger.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Pattern(regexp = "^[A-Za-z]*$", message = "{validation.name.notNumbers}")
    private String name;

    @Pattern(regexp = "^[A-Za-z]*$", message = "Unicamente caracteres alfabeticos")
    private String lastName;

    @Pattern(regexp = "^(.+)@(.+)$",message = "Email invalido")
    private String email;

    private String password,username;

    @Column(length = 10)
    @Size(min = 10, max = 10, message = "La cédula es de 10 digitos")
    private String ci;

    @JsonManagedReference
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    public Employee() {
    }

    public Employee(String id, String name, String lastName, String email, String password, String username, String ci, MedicalRecord medicalRecord) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.ci = ci;
        this.medicalRecord = medicalRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
