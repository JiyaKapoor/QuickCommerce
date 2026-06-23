package com.example.QuickCommerce.Entity;

public interface ReplenishmentStrategy {
    public void replenish(Long id,int sku,int qty);
}
