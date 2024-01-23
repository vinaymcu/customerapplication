package com.customer.controller;

import com.customer.model.Customer;
import com.customer.model.CustomerReq;
import com.customer.model.CustomerRes;
import com.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * Controller class describe the  customer request handle api details.
 * It had all end point for customer crud operation including
 *   save customer
 *   get customer
 *   delete customer
 *   update customer
 *
 */
@Slf4j
@RestController
@RequestMapping("customer/api/v1")
@OpenAPIDefinition(info = @Info(title = "Customer API", version = "2.0", description = "Customer api details for Create / Get/ Delete / Update operations for Customer Application "))
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * This rest end point responsible for create customer data
     * It used the CustomerService class as service for business logic provided
     * it return with status code 201
     * @param customerReq
     * @return ResponseEntity
     * @throws ParseException
     */
    @PostMapping("/save")
    public ResponseEntity<CustomerRes> createCustomer(@Valid @RequestBody CustomerReq customerReq) throws ParseException {
        log.info(" update Customer details with {} ",customerReq.getFirstName());
        CustomerRes customerResponse = customerService.saveCustomer(customerReq);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }


    /**
     * This rest end point for get all customer details with status code 200
     *
     * @return ResponseEntity
     */
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        log.info(" get All Customer details ");
        List<Customer> customerList= customerService.getAllCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    /**
     * this rest endpoint for used for getting particular customer details base upon id
     * it returned with status code 200
     * @param id of type long
     * @return ResponseEntity of CustomerRes
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerRes> getCustomer(@PathVariable(value = "id") Long id) {
        log.info("Get Customer Details with {} ",id);
        CustomerRes customerResponse= customerService.getCustomerDetails(id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    /**
     * This rest end point responsible for delete customer data
     * it returned with status code 200
     * @param id of type long
     * @return ResponseEntity as OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
        log.info("Delete Customer Details with {} ",id);
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    /**
     * This rest end point responsible for update customer data
     * it returned with status code 200
     * @param customer
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
        log.info(" update Customer details with {} ",customer.getFirstName());
        Customer customerResponse = customerService.updateCustomer(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }
}
