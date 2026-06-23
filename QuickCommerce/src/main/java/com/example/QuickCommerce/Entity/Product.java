package com.example.QuickCommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Data
@NoArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int sku;
    int qty;
    String name;
    double price;
}