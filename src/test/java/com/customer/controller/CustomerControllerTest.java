package com.customer.controller;

import com.customer.model.Customer;
import com.customer.model.CustomerRes;
import com.customer.service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    public void getAllCustomers() throws Exception {
          this.mvc.perform(MockMvcRequestBuilders
                        .get("/customer/api/v1/customers")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
       }

    @Test
    public void getSaveCustomers() throws Exception {
        Customer customer = new Customer(1, "vinay", "gupta",
                "vinay@gmail.com","male","14-6-1987");
        this.mvc.perform(post("/customer/api/v1/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated());
       }


    @Test
   public void getAllCustomer() throws Exception {
        long id = 1L;
        CustomerRes customer = new CustomerRes();
       when(customerService.getCustomerDetails(id)).thenReturn(customer);
        this.mvc.perform(get("/customer/api/v1/customer/{id}", 1L))
                .andExpect(status().isOk());
                  }



    @Test
    public void deleteCustomer() throws Exception {
        long id = 1L;

        doNothing().when(customerService).deleteCustomer(id);
        this.mvc.perform(delete("/customer/api/v1/delete/{id}", id))
                .andExpect(status().isOk());

    }
    @Test
    public void updateCustomer() throws Exception {
         long id = 1L;
        Customer customer = new Customer(1, "vinay", "gupta",
                "vinay@gmail.com","male","14-6-1987");
        Customer updateCustomer = new Customer(1, "vinay", "gupta",
                "vinay1@gmail.com","male","14-6-1987");
        when(customerService.updateCustomer(customer)).thenReturn(customer);
        this.mvc.perform(put("/customer/api/v1/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateCustomer)))
                .andExpect(status().isOk());

    }
}
