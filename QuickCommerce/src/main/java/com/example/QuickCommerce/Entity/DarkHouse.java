package com.example.QuickCommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.HashMap;

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
    @ElementCollection
    @CollectionTable(name="inventory_table",joinColumns = @JoinColumn(name="id"))
    @MapKeyColumn(name="sku")
    @Column(name="qty")
    HashMap<Integer,Integer> stock=new HashMap<>();

    public double getDistance(double user_x,double user_y){
        return Math.abs(user_x-x)+Math.abs(user_y-y);
    }
}




