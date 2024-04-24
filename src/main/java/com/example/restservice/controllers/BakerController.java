package com.example.restservice.controllers;

import com.example.restservice.dto.BakerDTO;
import com.example.restservice.dto.CakeDTO;
import com.example.restservice.entities.Baker;
import com.example.restservice.entities.Cake;
import com.example.restservice.repository.BakerRepository;
import com.example.restservice.services.BakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(@RequestBody BakerDTO dto, Principal principal){
        Baker baker = maptoBaker(dto);
        bakerService.save(baker, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
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

    private Baker maptoBaker(BakerDTO dto){
        Baker baker = new Baker();
        baker.setName(dto.getName());
        baker.setPhone(dto.getPhone());
        baker.setEmail(dto.getEmail());
        baker.setCakes(dto.getCakes());
        return baker;
    }

}
