package com.example.purchaseorder.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String name;
    private Integer code;
    private String manufacture;
    private Double price;
}
