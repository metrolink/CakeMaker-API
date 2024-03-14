package com.example.restservice.controllers;

import com.example.restservice.dto.BakerDTO;
import com.example.restservice.entities.Baker;
import com.example.restservice.repository.BakerRepository;
import com.example.restservice.services.BakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(
        value = "/api/baker",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class BakerController {

    private final BakerRepository bakerRepository;
    private final BakerService bakerService;

    @GetMapping
    public ResponseEntity<List<Baker>> getBakers(){
        return ResponseEntity.ok(bakerRepository.findAll());
    }

    @GetMapping("/bakerID")
    public ResponseEntity<BakerDTO> getSingleBaker(@PathVariable Long bakerID){
        Baker b = bakerRepository.getById(bakerID);

        if(Objects.isNull(b)){
            return ResponseEntity.notFound().build();
        }

        BakerDTO responseBody = BakerDTO.builder()
                .name(b.getName())
                .build();
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/delete/{bakerID}")
    public ResponseEntity<?> DeleteBaker(@PathVariable Long bakerID){
        Baker b = bakerRepository.getById(bakerID);
        bakerRepository.delete(b);
        if(Objects.isNull(b)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
