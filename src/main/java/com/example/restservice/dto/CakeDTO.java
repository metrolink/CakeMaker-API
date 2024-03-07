package com.example.restservice.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class CakeDTO {

    private String Cake;
    private String Ingredients;
}
