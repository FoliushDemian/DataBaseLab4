package org.example.dao;

import org.example.domain.Customer;

import java.util.Optional;

public interface CustomerDao extends GeneralDao<Customer, Integer> {
    Optional<Customer> findByCustomerName(String name);

    Optional<Customer> findByCustomerEmail(String email);
}
