package com.Shrishti.EmployeeAddressApplication.repository;

import com.Shrishti.EmployeeAddressApplication.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDao extends JpaRepository<Address,Integer> {
}
