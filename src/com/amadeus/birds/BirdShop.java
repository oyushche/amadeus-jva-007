package com.amadeus.birds;

import java.util.HashMap;

public class BirdShop {
    private HashMap<BirdType, Integer> stock;

    public BirdShop() {
        this.stock = new HashMap<>();
    }

    public void setStock(BirdType product, int count) {
        this.stock.put(product, count);
    }

    public boolean inStock(BirdType product, int count) {
        if (this.stock.containsKey(product)) {
            return this.stock.get(product) >= count;
        } else {
            return false;
        }
    }

    public void reduceStock(BirdType product, int count) {
        this.stock.put(product, this.stock.get(product) - count);
    }
}
