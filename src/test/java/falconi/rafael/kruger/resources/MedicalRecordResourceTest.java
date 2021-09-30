package falconi.rafael.kruger.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import falconi.rafael.kruger.dtos.MedicalRecordDto;
import falconi.rafael.kruger.entities.MedicalRecord;
import falconi.rafael.kruger.entities.Vaccine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MedicalRecordResource.class)
public class MedicalRecordResourceTest {

    @MockBean
    MedicalRecordResource medicalRecordResource;

    @Autowired
    private MockMvc mockMvc;

    private MedicalRecordDto medicalRecord;

    @Before
    public void before(){
        medicalRecord=new MedicalRecordDto();
        medicalRecord.setAddress("Pedregal");
        medicalRecord.setBirthDate("29/11/1990");
        medicalRecord.setVaccinated(true);
        medicalRecord.setDose(2);
        medicalRecord.setVaccineDate("11/09/2021");
        medicalRecord.setVaccine(Vaccine.Pfizer);

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateMedicalRecord() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders.patch("/medical-record/3baefffd-2f3d-47d1-94ef-877e99b9571a").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(medicalRecord));
        MvcResult result=mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("--->" + result.getResponse());
    }
}