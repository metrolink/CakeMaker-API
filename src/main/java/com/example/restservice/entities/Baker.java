package com.example.restservice.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Baker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String phone;

    private String email;

    @OneToMany(
            mappedBy = "cake",
            cascade = CascadeType.PERSIST
    )
    private List<Cake> cakes = new ArrayList<>();

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.PERSIST
    )
    private List<Customer> customers = new ArrayList<>();
}
