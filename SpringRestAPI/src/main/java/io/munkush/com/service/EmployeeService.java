package io.munkush.com.service;

import io.munkush.com.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> getAllEmployees();

     Employee getEmployee(int id);

     void delete(int id);

     void save(Employee employee);

     void update(Employee employee, int id);

}
