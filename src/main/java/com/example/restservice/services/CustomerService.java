package com.example.restservice.services;

import com.example.restservice.entities.Customer;
import com.example.restservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){ return customerRepository.findAll();}

    public void save(Customer cus, String name){customerRepository.save(cus);}
}
