package com.example.restservice.controllers;



import com.example.restservice.entities.Customer;
import com.example.restservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/customer",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> getCakes() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

}
