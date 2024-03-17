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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String adress;
    private String phone;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    @JsonBackReference
    private Customer customer;
}
