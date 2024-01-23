package com.customer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Customer class is for customers table mapping
 *
 */


@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer  implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    List< Orders > orders = new ArrayList< >();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Address address;

    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Address address;

}
