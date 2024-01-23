package com.customer.service;

import com.customer.entity.Address;
import com.customer.entity.Customer;
import com.customer.entity.Orders;
import com.customer.model.CustomerAddress;
import com.customer.model.CustomerOrders;
import com.customer.model.CustomerReq;
import com.customer.model.CustomerRes;
import com.customer.repository.CustomerRepository;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class CustomersServiceTest {
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerHelper customerHelper;

    @Mock
    ModelMapper modelMapper;

    @Test
    public void saveCustomer() throws ParseException {
        CustomerReq customerRequest=new CustomerReq();
        customerRequest.setEmail("test");
        customerRequest.setGender("gender");
        customerRequest.setFirstName("ddd");
        customerRequest.setLastName("dddd");
        customerRequest.setDob("01-May-1985");
        List<CustomerOrders> customerOrdersList=new ArrayList<>();
        CustomerOrders customerOrders=new CustomerOrders();
        customerOrders.setOrderDetails("aaaa");
        customerOrdersList.add(customerOrders);

        CustomerAddress customerAddress=new CustomerAddress();
        customerAddress.setId(1L);
        customerAddress.setLine1("test1");
        customerAddress.setLine2("test2");
        customerAddress.setCity("test3");
        customerAddress.setState("test4");
        customerAddress.setCountry("test5");
        customerAddress.setPin(1234);
        customerRequest.setCustomerAddress(customerAddress);
        customerRequest.setCustomerOrders(customerOrdersList);
        Customer customer = new Customer();
        customer.setEmail("vinay@gmail.com");
        customer.setFirstName("vinay");
        customer.setLastName("gupta");
        customer.setDob(new Date());

        List<Orders> orderList = new ArrayList< >();
        Orders orders=new Orders();
        orders.setOrderDetails("details");
        orders.setOrderDate(new Date());
        orderList.add(orders);
        customer.setOrders(orderList);

        Address address=new Address();
        address.setId(1L);
        address.setPin(12345);
        address.setLine1("line1");
        address.setLine2("3333");
        address.setState("ssss");
        address.setCountry("dddd");
        customer.setAddress(address);
        when(customerHelper.saveCustomer(Mockito.any())).thenReturn(customer);
        CustomerRes customerRes = customerService.saveCustomer(customerRequest);
        assertNotNull(customerRes);

    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setEmail("vinay@gmail.com");
        customer.setFirstName("vinay");
        customer.setLastName("gupta");
        customer.setDob(new Date());
        customerList.add(customer);
        when(customerRepository.findAll()).thenReturn(customerList);
        List<com.customer.model.Customer> customerList1 = customerService.getAllCustomer();
        assertNotNull(customerList1);
    }

    @Test
    public void testGetCustomer() {
        long id = 1L;
        Optional<com.customer.entity.Customer> customer = Optional.of(new Customer());
        customer.get().setEmail("test@gmail.com");
        customer.get().setFirstName("vinay1");
        customer.get().setLastName("vinay2");
        customer.get().setGender("Male");

        Address address=new Address();
        address.setLine1("line1");
        address.setLine2("line2");
        address.setCity("city1");
        address.setState("state");
        address.setCountry("country");
        address.setId(1L);
        address.setPin(13455);
        customer.get().setAddress(address);
        when(customerRepository.findById(1L)).thenReturn(customer);
        com.customer.model.CustomerRes customerRequest = customerService.getCustomerDetails(1L);
        assertNotNull(customerRequest);
    }

    @Test
    public void updateCustomer() {
        com.customer.model.Customer customerRequest = new com.customer.model.Customer();
        customerRequest.setId(1L);
        customerRequest.setEmail("vinay@gmail.com");
        customerRequest.setFirstName("vinayg");
        customerRequest.setLastName("guptaa");
        customerRequest.setGender("male");
        com.customer.entity.Customer customer = new com.customer.entity.Customer();
        customer.setEmail("test");
        customer.setFirstName("vinay");
        customer.setLastName("gupta");
        customer.setGender("male");
        when(customerRepository.getOne(1L)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        com.customer.model.Customer customer1 = customerService.updateCustomer(customerRequest);

        assertNotNull(customer1);
    }

    @Test
    public void tesDeleteCustomer_valid() {
        long id = 1L;
        Optional<com.customer.entity.Customer> customer = Optional.of(new Customer());
        customer.get().setEmail("test@gmail.com");
        customer.get().setFirstName("vinay1");
        customer.get().setLastName("vinay2");
        customer.get().setGender("Male");
        when(customerRepository.findById(1L)).thenReturn(customer);
        doNothing().when(customerRepository).delete(customer.get());;
        customerService.deleteCustomer(id);
    }
}
