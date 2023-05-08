package com.Shrishti.EmployeeAddressApplication.service;

import com.Shrishti.EmployeeAddressApplication.model.Address;
import com.Shrishti.EmployeeAddressApplication.model.Employee;
import com.Shrishti.EmployeeAddressApplication.repository.IAddressDao;
import com.Shrishti.EmployeeAddressApplication.repository.IEmployeeDao;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressDao addressDao;

    @Autowired
    IEmployeeDao employeeDao;


    public String createAddress(Address address) {
        addressDao.save(address);
        return "Address saved";
    }

    public List<Address> getAllAddress() {
        return addressDao.findAll();
    }

    public Address getAddressById(Integer id) {
        return addressDao.findById(id).get();
    }

    public String updateAddressById(Address address, Integer id) {
        Address oldAddress = addressDao.findById(id).get();
        if(oldAddress != null){
            oldAddress.setStreet(address.getStreet());
            oldAddress.setCity(address.getCity());
            oldAddress.setZipcode(address.getZipcode());
            addressDao.save(oldAddress);
            return oldAddress.toString();
        }
        return "Address Not Exist!!!";
    }

    public String deleteAddressById(Integer id) {
        List<Employee> recent = employeeDao.findAll();
        Address oldAddress = addressDao.findById(id).get();

        for(Employee employee : recent){
            if(employee.getAddress().getAddressId().equals(id)){
                addressDao.delete(oldAddress);
                return "Address Deleted!!!";
            }
        }
        return "Not Exist!!!";
    }
}
