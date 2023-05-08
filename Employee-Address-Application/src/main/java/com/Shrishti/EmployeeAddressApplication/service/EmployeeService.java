package com.Shrishti.EmployeeAddressApplication.service;

import com.Shrishti.EmployeeAddressApplication.model.Employee;
import com.Shrishti.EmployeeAddressApplication.repository.IEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeDao employeeDao;

    public String createEmployee(List<Employee> employee) {
        employeeDao.saveAll(employee);
        return "Employee Created!!!";
    }

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.findById(employeeId).get();
    }

    public String updateEmployeeById(Employee employee, Integer id) {
        Employee oldEmployee = employeeDao.findById(id).get();
        if(oldEmployee != null){
            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setAddress(employee.getAddress());
            employeeDao.save(oldEmployee);
            return oldEmployee.toString();
        }
        return "Employee Not Exist!!!";
    }

    public String deleteEmployeeById(Integer id) {
        Employee oldEmployee = employeeDao.findById(id).get();
        if(oldEmployee != null){
            employeeDao.delete(oldEmployee);
            return "Employee Deleted!!!";
        }
        return "Employee Not Exist!!!";
    }
}
