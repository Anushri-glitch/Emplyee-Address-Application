package com.Shrishti.EmployeeAddressApplication.controller;

import com.Shrishti.EmployeeAddressApplication.model.Address;
import com.Shrishti.EmployeeAddressApplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "address")
    public String createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @GetMapping(value = "address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping(value = "/addressId")
    public Address getAddressById(@RequestParam Integer id){
        return addressService.getAddressById(id);
    }

    @PutMapping(value = "/address")
    public String updateAddressById(@RequestBody Address address , @RequestParam Integer id){
        return addressService.updateAddressById(address,id);
    }

    @DeleteMapping(value = "/address")
    public String deleteAddressById(@RequestParam Integer id){
        return addressService.deleteAddressById(id);
    }
}
