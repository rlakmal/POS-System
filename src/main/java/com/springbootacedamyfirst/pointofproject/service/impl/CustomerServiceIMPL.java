package com.springbootacedamyfirst.pointofproject.service.impl;

import com.springbootacedamyfirst.pointofproject.dto.CustomerDTO;
import com.springbootacedamyfirst.pointofproject.entity.Customer;
import com.springbootacedamyfirst.pointofproject.repo.CustomerRepo;
import com.springbootacedamyfirst.pointofproject.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;
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

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerId())){

            Customer customer = customerRepo.getReferenceById(customerDTO.getCustomerId());
            //System.out.println(customer);
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());

            customerRepo.save(customer);
            return "Updated";
        }else{
            System.out.println("No customer found for update");
            return "No customer found for update";
        }

    }

    @Override
    public CustomerDTO getCustomer(int customerID) {
        Customer customer = customerRepo.getReferenceById(customerID);
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);

//        if(customer!=null){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getContactNumber(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//            return customerDTO;
//        }else {
//            return null;
//        }
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomers  = customerRepo.findAll();
        System.out.println(getCustomers);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
//        for(Customer customer:getCustomers){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getContactNumber(),
//                    customer.getNic(),
//                    customer.isActiveState()
//
//            );
//            customerDTOList.add(customerDTO);
//
//        }
        //return customerDTOList;

        if(getCustomers!=null){
            customerDTOList = modelMapper.
                    map(getCustomers,new TypeToken<List<CustomerDTO>>(){
                    }.getType());
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted";
        }else{
            return "customer not found";
        }

    }

}
