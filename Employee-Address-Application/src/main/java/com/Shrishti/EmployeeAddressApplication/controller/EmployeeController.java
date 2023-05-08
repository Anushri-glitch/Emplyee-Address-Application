package com.Shrishti.EmployeeAddressApplication.controller;

import com.Shrishti.EmployeeAddressApplication.model.Employee;
import com.Shrishti.EmployeeAddressApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Create Employee
    @PostMapping(value = "/employee")
    public String createEmployee(@RequestBody List<Employee> employee){
        return employeeService.createEmployee(employee);
    }

    //Get Employee
    @GetMapping(value = "/employee")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    //Get Emloyee By id
    @GetMapping(value = "/employeeId")
    public Employee getEmployeeById(@RequestParam Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    //Update Employee
    @PutMapping(value = "/employee")
    public String updateEmployeeById(@RequestBody Employee employee, @RequestParam Integer id){
        return employeeService.updateEmployeeById(employee,id);
    }

    //Delete Employee
    @DeleteMapping(value = "/employee")
    public String deleteEmployeeById(@RequestParam Integer id){
        return employeeService.deleteEmployeeById(id);
    }
}
