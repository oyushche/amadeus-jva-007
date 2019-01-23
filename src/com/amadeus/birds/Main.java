package com.amadeus.birds;

public class Main {
    public static void main(String[] args) {
        BirdShop shop = new BirdShop();

        shop.setStock(BirdType.DUCK, 2);
        shop.setStock(BirdType.EAGLE, 10);

        shop.buy("Vasya", BirdType.EAGLE, 2);
        shop.buy("Petya", BirdType.DUCK, 1);
        shop.buy("Vasya", BirdType.DUCK, 1);
        shop.buy("Petya", BirdType.DUCK, 1);
        shop.buy("Vasya", BirdType.EAGLE, 5);

        shop.printStats();
    }
}
