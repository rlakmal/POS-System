package com.springbootacedamyfirst.pointofproject.controller;

import com.springbootacedamyfirst.pointofproject.dto.CustomerDTO;
import com.springbootacedamyfirst.pointofproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.addCustomer(customerDTO);

        return "saved";

    }
}
