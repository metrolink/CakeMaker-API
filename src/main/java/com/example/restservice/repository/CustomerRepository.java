package com.example.restservice.repository;

import com.example.restservice.entities.Cake;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @Query("select cus from Customer cus where cus.name=:name")
    public Cake findByName(String name);
}
