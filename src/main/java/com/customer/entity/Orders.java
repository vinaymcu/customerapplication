package com.customer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Orders class is for orders table mapping
 *
 */

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_details")
    private String orderDetails;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer  customer;
}
