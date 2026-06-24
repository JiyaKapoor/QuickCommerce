package com.example.QuickCommerce.Services;

import com.example.QuickCommerce.Entity.Cart;
import com.example.QuickCommerce.Entity.DarkHouse;
import com.example.QuickCommerce.Entity.Product;
import com.example.QuickCommerce.Entity.User;
import com.example.QuickCommerce.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService {
    //this service allows a user to add items  to cart, remove items from the cart and place an order
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DarkHouseService darkHouseService;

    public void addItem(int sku,long userId){
        User user=userRepo.findById(userId).orElseThrow();
        Cart user_cart=user.getCart();
        HashMap<Integer,Integer> map=user_cart.getCurrCartItems();
        map.put(sku,map.getOrDefault(sku,0)+1);
        user_cart.setCurrCartItems(map);
    }
    //we require a function to view all the products from the valid darkhouses
    public List<Product> viewItems(long userId){
        User user=userRepo.findById(userId).orElseThrow();
        double user_x=user.getX();
        double user_y= user.getY();
        List<DarkHouse> validDarkHouses=darkHouseService.fetchNearestWarehouse(5,user_x,user_y);
        List<Product> products=new ArrayList<>();
        return products;
    }
}
