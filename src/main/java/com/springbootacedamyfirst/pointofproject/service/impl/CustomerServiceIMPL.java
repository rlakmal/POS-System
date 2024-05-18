package com.springbootacedamyfirst.pointofproject.service.impl;

import com.springbootacedamyfirst.pointofproject.dto.CustomerDTO;
import com.springbootacedamyfirst.pointofproject.entity.Customer;
import com.springbootacedamyfirst.pointofproject.repo.CustomerRepo;
import com.springbootacedamyfirst.pointofproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(

              customerDTO.getCustomerId(),
              customerDTO.getCustomerName(),
              customerDTO.getCustomerAddress(),
              customerDTO.getCustomerSalary(),
              customerDTO.getContactNumber(),
              customerDTO.getNic(),
              customerDTO.isActiveState()
        );

        if(!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
        }else{
            System.out.println("Customer is already exists");
        }
    }

}
