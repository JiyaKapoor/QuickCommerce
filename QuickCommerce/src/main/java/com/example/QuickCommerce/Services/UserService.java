package com.example.QuickCommerce.Services;

import com.example.QuickCommerce.Entity.Cart;
import com.example.QuickCommerce.Entity.User;
import com.example.QuickCommerce.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class UserService {
    //this service allows a user to add items  to cart, remove items from the cart and place an order
    @Autowired
    private UserRepo userRepo;
    public void addItem(int sku,long userId){
        User user=userRepo.findById(userId).orElseThrow();
        Cart user_cart=user.getCart();
        HashMap<Integer,Integer> map=user_cart.getCurrCartItems();
        map.put(sku,map.getOrDefault(sku,0)+1);
        user_cart.setCurrCartItems(map);

    }
}
