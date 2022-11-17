package io.munkush.com.controller;

import io.munkush.com.entity.Employee;
import io.munkush.com.entity.Response;
import io.munkush.com.exception.NoSuchEmployeeException;
import io.munkush.com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/** 17.11.2022 21:33
 * author: Munkush)
 */

@RestController
@RequestMapping("/api/employees")
public class MainController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Response> showAllEmployees(){

        return ResponseEntity.accepted().body( Response.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .message("all employees has successfully fetched")
                .data(Map.of("Employees", employeeService.getAllEmployees()))
                .build());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Response> showOneEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException(String.format("Employee with id : %s not found", id));
        }
        return ResponseEntity.accepted().body( Response.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .message("employee has successfully fetched")
                .data(Map.of("Employee", employeeService.getEmployee(id)))
                .build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id){

        employeeService.delete(id);
    }
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
        employeeService.update(employee, id);
    }




}
