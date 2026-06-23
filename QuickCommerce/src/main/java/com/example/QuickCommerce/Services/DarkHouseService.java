package com.example.QuickCommerce.Services;

import com.example.QuickCommerce.Entity.DarkHouse;
import com.example.QuickCommerce.Repository.DarkHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DarkHouseService {
    @Autowired
    DarkHouseRepo darkHouseRepo;
    public List<DarkHouse> fetchNearestWarehouse(double radius, double user_x,double user_y){
        //basically this function returns a list of all the dark houses within "radius" km
        List<DarkHouse> allHouses=darkHouseRepo.findAll();
        List<DarkHouse> validDarkHouse=new ArrayList<>();
        for(DarkHouse house:allHouses){
            if(house.getDistance(user_x,user_y)<=radius){
                validDarkHouse.add(house);
            }
        }
        return validDarkHouse;
    }
    //adding inventory
    public void addInventory(long id,int sku,int qty){
        DarkHouse darkHouse=darkHouseRepo.findById(id).orElseThrow();
        HashMap<Integer,Integer> map=darkHouse.getStock();
        map.put(sku,map.getOrDefault(sku,0)+1);
        darkHouse.setStock(map);
        darkHouseRepo.save(darkHouse);
    }
}
