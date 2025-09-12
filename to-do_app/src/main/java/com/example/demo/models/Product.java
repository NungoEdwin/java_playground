package com.example.demo.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product{
    @Id
    private Long id;

    private String name;
    private Double price;

}
