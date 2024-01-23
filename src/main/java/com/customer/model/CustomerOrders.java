package com.customer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerOrders {

    @JsonProperty("id")
    private long id;

    @JsonProperty("order_details")
    private String orderDetails;

    @JsonProperty("order_date")
    private String orderDate;
}
