package com.amadeus.birds;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addBird("Ворона", 1);
        shop.addBird("Сокол", 5);
        shop.addBird("Утка", 0.5);

        shop.addStock("Ворона", 20 + 3);
        shop.addStock("Сокол", 23 + 1);
        shop.addStock("Утка", 4 + 23);

        shop.buy("Вася", "Ворона", 3);
        shop.buy("Вася", "Сокол", 1);
        shop.buy("Вася", "Утка", 23);
    }
}
