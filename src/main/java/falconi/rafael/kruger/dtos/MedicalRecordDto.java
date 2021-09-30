package falconi.rafael.kruger.dtos;

import falconi.rafael.kruger.entities.Vaccine;

import javax.validation.constraints.Size;

public class MedicalRecordDto {

    private String birthDate, vaccineDate, address, phone;

    private boolean vaccinated;


    private int dose;

    private Vaccine vaccine;

    public MedicalRecordDto() {
    }

    public MedicalRecordDto(String birthDate, String vaccineDate, String address, String phone, boolean vaccinated, int dose, Vaccine vaccine) {
        this.birthDate = birthDate;
        this.vaccineDate = vaccineDate;
        this.address = address;
        this.phone = phone;
        this.vaccinated = vaccinated;
        this.dose = dose;
        this.vaccine = vaccine;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(String vaccineDate) {
        this.vaccineDate = vaccineDate;
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

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
