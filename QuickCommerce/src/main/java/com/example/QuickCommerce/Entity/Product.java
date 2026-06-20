package com.example.QuickCommerce.Entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
class Product{
    int sku;
    int qty;
    String name;
}