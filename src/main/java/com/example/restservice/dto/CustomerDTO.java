package com.example.restservice.dto;

import com.example.restservice.entities.Cake;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDTO {

    String name;

    String address;

    String phone;

    List<Cake> order;
}
