package falconi.rafael.kruger.repositories;

import falconi.rafael.kruger.entities.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void insertEmployee(){
        Employee employee= new Employee();
        employee.setCi("1716203292");
        employee.setName("Rafael");
        employee.setLastName("Falconi");
        employee.setEmail("r.falconi9030@gmail.com");
        System.out.println("--->"+entityManager.persistAndGetId(employee));
    }


}