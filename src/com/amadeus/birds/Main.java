package com.amadeus.birds;

public class Main {
    public static void main(String[] args) {
        BirdShop shop = new BirdShop();

        shop.setStock(BirdType.DUCK, 2);
        shop.setStock(BirdType.EAGLE, 10);
    }
}
