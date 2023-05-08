package com.Shrishti.EmployeeAddressApplication.repository;

import com.Shrishti.EmployeeAddressApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Integer> {
}
