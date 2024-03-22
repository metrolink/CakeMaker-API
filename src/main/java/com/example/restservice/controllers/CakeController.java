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
import org.springframework.http.HttpStatus;
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

	@GetMapping("/personal")
	public ResponseEntity<List<Cake>> myCakes(Principal principal){
		List<Cake> myCakes = cakeService.getCakeObjects(principal.getName());
		return ResponseEntity.ok(myCakes);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cake> createCake(@RequestBody CakeDTO dto, Principal principal){
		Cake cake = mapToCake(dto);
		cakeService.save(cake, principal.getName());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/delete/{BakerID}")
	public ResponseEntity<?> deleteCake(@PathVariable Long cakeID){
		Cake cake = cakeRepository.getById(cakeID);
		cakeRepository.delete(cake);
		if(Objects.isNull(cake)){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	private Cake mapToCake(CakeDTO dto){
		Cake cake = new Cake();
		cake.setCakeName(dto.getCakeName());
		cake.setIngredients(dto.getIngredients());
		return cake;
	}
}
