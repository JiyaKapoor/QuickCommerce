package com.example.QuickCommerce.Entity;

import com.example.QuickCommerce.Repository.ProductRepo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Entity
@Data
public class Cart {
    @Autowired
    private ProductRepo productRepo;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long cart_id;
    //now for this cart basically we need to be maintaing the products along with their qty
    @ElementCollection
    @CollectionTable(name="curr_cart_items",joinColumns = @JoinColumn(name="cart_id"))
    @MapKeyColumn(name = "sku")
    @Column(name="qty")
    private HashMap<Integer,Integer> currCartItems;
    //helper method to compute the cost of the cart
    public double getTotalCost(){
        double cost=0;
        for(int key:currCartItems.keySet()){
            Product product=productRepo.findById(key).orElseThrow();
            int qty=product.getQty();
            double price= product.getPrice();
            cost+=qty * price;
        }
        return cost;
    }
}
