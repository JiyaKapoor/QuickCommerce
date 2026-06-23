package com.example.QuickCommerce.Repository;

import com.example.QuickCommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
