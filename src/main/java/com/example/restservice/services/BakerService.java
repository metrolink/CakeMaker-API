package com.example.restservice.services;

import com.example.restservice.dto.BakerDTO;
import com.example.restservice.entities.Baker;
import com.example.restservice.repository.BakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BakerService {

    private final BakerRepository bakerRepository;

    public Boolean createBaker(BakerDTO bakerDTO){
        if(Objects.nonNull(bakerRepository.findByBaker(bakerDTO.getName()))){
            return false;
        }

        Baker baker = new Baker();
        baker.setName(bakerDTO.getName());
        baker.setEmail(bakerDTO.getEmail());
        baker.setPhone(bakerDTO.getPhone());
        baker.setCakes(new ArrayList<>());
        bakerRepository.save(baker);
        return true;
    }
}
