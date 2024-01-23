package com.customer.repository;

import com.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Customer repository  interface is used as backend operation for customer table.
 *  it used Jpa Repository for crud operations for customers table
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}



