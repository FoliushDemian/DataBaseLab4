package org.example.controller.impl;

import org.example.controller.CustomerController;
import org.example.domain.Customer;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Optional<Customer> findByCustomerName(String name) {
        return customerService.findByCustomerName(name);
    }

    @Override
    public Optional<Customer> findByCustomerEmail(String email) {
        return customerService.findByCustomerEmail(email);
    }

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerService.findById(id);
    }

    @Override
    public int create(Customer customer) {
        return customerService.create(customer);
    }

    @Override
    public int update(Integer id, Customer customer) {
        return customerService.update(id, customer);
    }

    @Override
    public int delete(Integer id) {
        return customerService.delete(id);
    }
}
