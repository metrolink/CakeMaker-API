package com.example.restservice.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.dto.CakeDTO;
import com.example.restservice.entities.Cake;
import com.example.restservice.repository.CakeRepository;
import com.example.restservice.services.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
		value = "/api/cake",
		produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class CakeController {

	private final CakeService cakeService;
	private CakeRepository cakeRepository;

	@GetMapping()
	public ResponseEntity<List<Cake>> getCakes() {
		return ResponseEntity.ok(cakeRepository.findAll());
	}

	/*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cake> createCake(@RequestBody CakeDTO dto, Principal principal){
		var cake = mapToCake(dto);
	}*/
}
