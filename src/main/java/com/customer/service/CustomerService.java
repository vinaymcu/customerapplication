package com.customer.service;

import com.customer.entity.Address;
import com.customer.entity.Orders;
import com.customer.exception.ResourceNotFoundException;
import com.customer.model.*;
import com.customer.repository.CustomerRepository;
import com.customer.util.CustomerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Customer Service class for business logic implementation for customer details.
 * It provided the details for business implementation for operation as
 * it' save customer
 * it' update customer
 * it' delete customer
 * it'  get customer
 * It is using the Customer Repository for backend operation for database operation
 *
 */
@Slf4j
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerHelper customerHelper;

    final ModelMapper modelMapper = new ModelMapper();

    /**
     * this method use for save customers details with Orders and Address
     * It taken customerRequest as parameter and return CustomerRes
     * using the ModelMapper for entity to model mapper
     *
     * @param customerRequest of CustomerReq
     * @return customerRes of CustomerRes
     * @throws ParseException ParseException
     */
    public CustomerRes saveCustomer(CustomerReq customerRequest) throws ParseException {
        log.info("saveCustomer for customer ********* ");
        List<String> userMessages=new ArrayList<>();
        List<String> serviceErrors=new ArrayList<>();

       com.customer.entity.Customer customer=new com.customer.entity.Customer();
        customer.setFirstName(customerRequest.getFirstName());
        if(StringUtils.isBlank(customerRequest.getFirstName())){
            userMessages.add("Customer First  name is missing");
        }
        if(StringUtils.isBlank(customerRequest.getLastName())){
            userMessages.add("Customer Last  name is missing");
        }

        customer.setLastName(customerRequest.getLastName());
        customer.setGender(customerRequest.getGender());
        customer.setEmail(customerRequest.getEmail());
        customer.setDob(CustomerUtil.getDateFromString(customerRequest.getDob()));
        List<CustomerOrders>  customerOrders=customerRequest.getCustomerOrders();
        List<Orders> orderList=new ArrayList<>();
        for(CustomerOrders orders:customerOrders){
            Orders order=new Orders();
            order.setOrderDetails(orders.getOrderDetails());
            order.setOrderDate(new Date());
            order.setCustomer(customer);
            orderList.add(order);
        }
        customer.setOrders(orderList);
        Address address=null;
        try{
             address=modelMapper.map(customerRequest.getCustomerAddress(), Address.class);
        }catch(Exception exception){
            serviceErrors.add(exception.getMessage());
        }
        address.setCustomer(customer);
        customer.setAddress(address);

        com.customer.entity.Customer customer2=customerHelper.saveCustomer(customer);
        CustomerRes customerResponse = new CustomerRes();
        Payload payload=getPayload(customer2);
        List<CustomerOrders> customerOrdersList=getOrdersList(customer2);
        payload.setCustomerOrders(customerOrdersList);
        payload.setCustomerAddress(modelMapper.map(address, CustomerAddress.class));
        customerResponse.setPayload(payload);
        customerResponse.setUserMessages(userMessages);
        customerResponse.setServiceErrors(serviceErrors);
        return customerResponse;
    }
    /**
     *  This method is used for get customer details along with Orders and Address detail based upon id
     *  It used parameter as id and return CustomerRes object
     * @param id id
     * @return CustomerRes
     */
    public CustomerRes getCustomerDetails(long id){
        log.info(" getCustomer {} ",id);

        List<String> userMessages=new ArrayList<>();
        List<String> serviceErrors=new ArrayList<>();
        if(StringUtils.isBlank(Long.toString(id))){
            userMessages.add(" Requested customer ID is  null");
        }
        Optional<com.customer.entity.Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new ResourceNotFoundException("Resource is not found for Id ", id);
        }
        CustomerRes customerResponse = new CustomerRes();
        Payload payload = getPayloadFromCustomer(customer.get());

        List<CustomerOrders>  customerOrdersList=getOrdersList(customer.get());
        payload.setCustomerOrders(customerOrdersList);

        Address  address=customer.get().getAddress();
        CustomerAddress customerAddress =null;
        try{
            customerAddress = modelMapper.map(address, CustomerAddress.class);
        }catch(Exception exception){
            serviceErrors.add(exception.getMessage());
        }

        payload.setCustomerAddress(customerAddress);
        customerResponse.setPayload(payload);
        customerResponse.setUserMessages(userMessages);
        customerResponse.setServiceErrors(serviceErrors);
        return customerResponse;
    }

    /**
     * This method prepare the payload for customer
     * @param customer Customer
     * @return Payload
     */
    private Payload getPayload(com.customer.entity.Customer customer){
        Payload payload = getPayloadFromCustomer(customer);
        payload.setDob(CustomerUtil.getDateAsString(customer.getDob()));
        return payload;

    }


    /**
     * This method is for prepare the CustomerOrders list for customer
     * @param customer
     * @return customerOrdersList of CustomerOrders
     */
    private List<CustomerOrders> getOrdersList(com.customer.entity.Customer customer){
        List<Orders> ordersList=  customer.getOrders();
        List<CustomerOrders> customerOrdersList=new ArrayList<>();
        for(Orders orders:ordersList){
            CustomerOrders customerOrders=new CustomerOrders();
            customerOrders.setOrderDetails(orders.getOrderDetails());
            customerOrders.setId(orders.getId());
            customerOrders.setOrderDate(CustomerUtil.getDateAsString(orders.getOrderDate()));
            customerOrdersList.add(customerOrders);
        }
        return customerOrdersList;
    }



    /**
     * This method for prepare  Customer response from Customer entity
     * @param customer Customer
     * @return customerResponse Customer
      */
    private Customer getCustomerResponse(com.customer.entity.Customer customer) {
        Customer   customerResponse=new Customer();
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setId(customer.getId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setGender(customer.getGender());
        customerResponse.setEmail(customer.getEmail());
        return customerResponse;
    }

    /**
     * This method for update customer details using the customerRepository
     * It fetched the customer record and update the attributes
     * @param customerRequest Customer
     * @return customer of type Customer
     */
    public Customer updateCustomer(final Customer customerRequest){
        log.info("updateCustomer for customer ********* ");
        com.customer.entity.Customer customer=customerRepository.getOne(customerRequest.getId());
            customer.setFirstName(customerRequest.getFirstName());
            customer.setLastName(customerRequest.getLastName());
            customer.setGender(customerRequest.getGender());
            customer.setEmail(customerRequest.getEmail());
        com.customer.entity.Customer savedCustomer=customerRepository.save(customer);
        return getCustomerResponse(savedCustomer);
    }


    /**
     * This method is prepared the Payload details for response from customer entity
     * @param customer of Customer
     * @return payload of Payload
     */
    private Payload getPayloadFromCustomer(com.customer.entity.Customer customer) {
        Payload payload=new Payload();
        payload.setLastName(customer.getLastName());
        payload.setId(Long.toString(customer.getId()));
        payload.setFirstName(customer.getFirstName());
        payload.setGender(customer.getGender());
        payload.setEmail(customer.getEmail());
        return payload;
    }

    /**
     *  This method for delete Customer based upon id using Customer Repository
     *  if customer is not found in this case throw Exception
     *  @param id id
     */
    public void deleteCustomer(long id) {
        log.info(" deleteCustomer id {}", id);
        Optional<com.customer.entity.Customer> customer1 = customerRepository.findById(id);

        if (!customer1.isPresent()) {
            throw new ResourceNotFoundException("Resource is not found for Id ", id);
        }
        customerRepository.delete(customer1.get());
    }

    /**
     *  this method for getting details of all customer details .it use customerRepository for backend call and fetch all record from database
     *  It prepared the response from customer details from database table customers,orders,address
     *
     * @return List<Customer> of List of Customer
     */
    public List<Customer> getAllCustomer(){
        log.info("saveCustomer for customer ********* ");
        List<com.customer.entity.Customer> customersList=customerRepository.findAll();
        List<Customer> customerList=new ArrayList<>();
        for(com.customer.entity.Customer customer:customersList){
            Customer customerResponse=new Customer();
            customerResponse.setId(customer.getId());
            customerResponse.setFirstName(customer.getFirstName());
            customerResponse.setLastName(customer.getLastName());
            customerResponse.setGender(customer.getGender());
            customerResponse.setEmail(customer.getEmail());
            customerResponse.setDob(CustomerUtil.getDateAsString(customer.getDob()));
            customerList.add(customerResponse);
        }
        return customerList;
    }
}
