package com.example.restservice.repository;


import com.example.restservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select cus from Customer cus where cus.name=:name")
    public Customer findByName(String name);
}
