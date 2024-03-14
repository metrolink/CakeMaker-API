package com.example.restservice.dto;

import lombok.Builder;
import lombok.Data;
import com.example.restservice.entities.Cake;

import java.util.List;

@Data
@Builder
public class BakerDTO {

    private String name;
    private String phone;
    private String email;
    private List<Cake> cakes;
}
