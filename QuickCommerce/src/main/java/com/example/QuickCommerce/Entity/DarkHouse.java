package com.example.QuickCommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@Entity
@Data
@NoArgsConstructor
public class DarkHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double x;
    private double y;
    private String address;
    private int zipcode;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="id")
    private Inventory inventory;
    public double getDistance(double user_x,double user_y){
        return Math.abs(user_x-x)+Math.abs(user_y-y);
    }

}
