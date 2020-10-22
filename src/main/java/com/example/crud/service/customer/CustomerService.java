package com.example.crud.service.customer;

import com.example.crud.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Customer save(Customer customer);
    void remove(Integer id);
}
