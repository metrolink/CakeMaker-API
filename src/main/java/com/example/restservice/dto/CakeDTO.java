package com.example.restservice.dto;

import lombok.Data;
import lombok.Builder;

import java.util.List;

@Data
@Builder
public class CakeDTO {

    private String cakeName;
    private String ingredients;
}
