package com.example.restservice.controllers;



import com.example.restservice.dto.CustomerDTO;
import com.example.restservice.entities.Customer;
import com.example.restservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(
        value = "/api/customer",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerDTO customerDTO;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<CustomerDTO> getSingleCustomer(@PathVariable Long customerID){
        Customer cus = customerRepository.getById(customerID);
        if(Objects.isNull(cus)){
            return ResponseEntity.notFound().build();
        }

        CustomerDTO responseBody = CustomerDTO.builder().name(cus.getName()).address(cus.getAddress()).phone(cus.getPhone()).order(cus.getOrder()).build();

        return ResponseEntity.ok(responseBody);

        //CustomerDTO responseBody = customerDTO.builder().name
    }

}
