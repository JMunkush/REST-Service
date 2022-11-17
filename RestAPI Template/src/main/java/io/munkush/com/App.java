package io.munkush.com;

import io.munkush.com.config.MyConfig;
import io.munkush.com.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App {
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        // ALL EMPLOYEES
        List<Employee> employees = communication.showAllEmployees();
        System.out.println(employees);

        // SHOW ONE EMPLOYEE
        Employee employee = communication.showEmployee(1);
        System.out.println(employee);

        // DELETE EMPLOYEE
        communication.deleteEmployee(2);

        // UPDATE EMPLOYEE
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName("New Employee from Another APP");
        updatedEmployee.setSurname("Java");
        updatedEmployee.setDepartment("SPRING");

        communication.updateEmployee(updatedEmployee, 3);

    }
}
