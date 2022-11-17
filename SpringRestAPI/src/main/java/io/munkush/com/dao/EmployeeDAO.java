package io.munkush.com.dao;

import io.munkush.com.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);

    void update(Employee employee, int id);

}
