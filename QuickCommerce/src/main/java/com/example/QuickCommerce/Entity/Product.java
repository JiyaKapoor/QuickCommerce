package com.example.QuickCommerce.Entity;

import jakarta.persistence.Entity;

@Entity
class Product{
    int sku;
    int qty;
    String name;

}