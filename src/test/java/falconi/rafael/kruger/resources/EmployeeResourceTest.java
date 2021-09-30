package falconi.rafael.kruger.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import falconi.rafael.kruger.dtos.EmployeeDto;
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



@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeResource.class)
public class EmployeeResourceTest {

    @MockBean
    private EmployeeResource employeeResource;
    @Autowired
    private MockMvc mockMvc;

    private EmployeeDto employeeDto;

    @Before
    public void before() {
        employeeDto = new EmployeeDto();
        employeeDto.setEmail("r.falconi9030@gmail.com");
        employeeDto.setCi("1716203292");
        employeeDto.setName("Rafael");
        employeeDto.setLastName("Falconi");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void registerEmployee() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(this.employeeDto));
        MvcResult result = mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("--->" + result.getResponse());
    }

    @Test
    public void getEmployeeByVaccinated() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/employee/vaccinated/true");
        MvcResult result=mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("--->" + result.getResponse());
    }

    @Test
    public void getEmployeeByVaccine() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/employee/vaccine/Sputnik");
        MvcResult result=mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("--->" + result.getResponse());
    }

    @Test
    public void getEmployeeByDate() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/employee/vaccine/Sputnik");
        MvcResult result=mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("--->" + result.getResponse());
    }
}