package io.munkush.com;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.munkush.com.entity.Employee;
import io.munkush.com.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

/** 17.11.2022 21:33
 * author: Munkush)
 */
@Component
public class Communication {

    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/employees";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> showAllEmployees(){

        ResponseEntity<Response> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<Response>() {});

        Map<String, List<Employee>> employeeData = (Map<String, List<Employee>>) responseEntity.getBody().getData();
        return employeeData.get("Employees");
    }

    public Employee showEmployee(int id){
        ResponseEntity<Response> responseEntity = restTemplate.exchange(URL + "/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Response>(){});
        Map<String, Employee> employeeData = (Map<String, Employee>) responseEntity.getBody().getData();

        Employee employee = new ObjectMapper().convertValue(employeeData
                .get("Employee"), Employee.class);

        return employee;

    }

    public void updateEmployee(Employee employee, int id){
        restTemplate.put(URL + "/" + id, employee, Employee.class);
    }

    public void deleteEmployee(int id){
        restTemplate.delete(URL + "/" + id, HttpMethod.DELETE);
    }

}
