package io.munkush.com.service;

import io.munkush.com.dao.EmployeeDAOImpl;
import io.munkush.com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAOImpl employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }
    @Override
    @Transactional
    public Employee getEmployee(int id){
        return employeeDAO.getEmployee(id);
    }
    @Override
    @Transactional
    public void delete(int id){
        employeeDAO.deleteEmployee(id);
    }
    @Override
    @Transactional
    public void save(Employee employee){
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        employeeDAO.update(employee, id);
    }

}
