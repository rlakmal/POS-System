package com.springbootacedamyfirst.pointofproject.controller;

import com.springbootacedamyfirst.pointofproject.dto.CustomerDTO;
import com.springbootacedamyfirst.pointofproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.addCustomer(customerDTO);
        //System.out.println(customerDTO);
        return "saved";

    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        String update = customerService.updateCustomer(customerDTO);
        return update;
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerID){
        CustomerDTO customerDTO = customerService.getCustomer(customerID);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-custoers")
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> customerDTOS = customerService.getAllCustomer();
        return customerDTOS;

    }

    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

}
