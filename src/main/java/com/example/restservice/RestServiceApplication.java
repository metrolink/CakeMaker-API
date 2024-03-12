package com.example.restservice;

import com.example.restservice.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RestServiceApplication {

    @Autowired
    private CakeRepository cakeRepository;
    public static void main(String[] args) {

        SpringApplication.run(RestServiceApplication.class, args);
    }

}
