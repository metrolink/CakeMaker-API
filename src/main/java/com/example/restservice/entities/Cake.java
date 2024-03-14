package com.example.restservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cake {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cakeName;

	private String ingredients;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn()
	@JsonBackReference
	private Cake cake;
}
