package com.example.QuickCommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double x;
    private double y;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private Cart cart;
}
