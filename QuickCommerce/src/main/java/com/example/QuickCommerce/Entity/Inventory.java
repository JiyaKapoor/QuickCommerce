package com.example.QuickCommerce.Entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    //this class is specific to each DarkHouse
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    @CollectionTable(name="inventory_table",joinColumns = @JoinColumn(name="id"))
    @MapKeyColumn(name="sku")
    @Column(name="qty")
    HashMap<Integer,Integer> stock=new HashMap<>();
}
