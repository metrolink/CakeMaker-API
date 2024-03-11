package com.example.restservice.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.entities.Cake;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
		value = "/api/cake",
		produces = MediaType.APPLICATION_JSON_VALUE
)
public class CakeController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	@GetMapping("/Cake")
	public Cake greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Cake();
	}
}
