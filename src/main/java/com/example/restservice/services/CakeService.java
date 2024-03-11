package com.example.restservice.services;

import com.example.restservice.controllers.CakeController;
import com.example.restservice.dto.CakeDTO;
import com.example.restservice.repository.CakeRepository;
import com.example.restservice.entities.Cake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CakeService {

    private final CakeRepository cakeRepository;

    public Boolean createCake(CakeDTO cakeDTO){
        if(Objects.nonNull(cakeRepository.findByName(cakeDTO.getCakeName()))){
            return false;
        }

        Cake newCake = new Cake();
        newCake.setCakeName(cakeDTO.getCakeName());

        cakeRepository.save(newCake);
        return true;


    }
}
