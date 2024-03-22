package com.example.restservice.services;

import com.example.restservice.controllers.CakeController;
import com.example.restservice.dto.CakeDTO;
import com.example.restservice.repository.CakeRepository;
import com.example.restservice.entities.Cake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CakeService {

    private final CakeRepository cakeRepository;

    public List<Cake> getAllCakes(){
        return cakeRepository.findAll();
    }

    public void save(Cake c, String name){
        cakeRepository.save(c);
    }

    public List<Cake> getCakeObjects(String name) {
        return cakeRepository.findByName(name).stream().collect(Collectors.toList());
    }
}
