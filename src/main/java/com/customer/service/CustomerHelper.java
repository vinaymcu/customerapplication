package com.customer.service;

import com.customer.model.CustomerRes;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Customer helper class
 */
@Service
public class CustomerHelper {

    @Autowired
    CustomerRepository customerRepository;

    public com.customer.entity.Customer  saveCustomer(com.customer.entity.Customer customer){
        com.customer.entity.Customer customerObject=customerRepository.save(customer);
        return customerObject;
    }

}
