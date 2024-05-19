package com.springbootacedamyfirst.pointofproject.service;

import com.springbootacedamyfirst.pointofproject.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {




    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(int customerID);

    List<CustomerDTO> getAllCustomer();

    String deleteCustomer(int customerId);
}
