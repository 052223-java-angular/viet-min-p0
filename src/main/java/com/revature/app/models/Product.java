package com.revature.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int category;
    private int stock;
}
