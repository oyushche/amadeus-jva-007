package com.amadeus.birds;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addBird("Ворона", 1);
        shop.addBird("Сокол", 5);
        shop.addBird("Утка", 0.5);

        shop.addStock("Ворона", 20 + 3);
        shop.addStock("Сокол", 23 + 1);
        shop.addStock("Утка", 2 + 23);

        shop.buy("Вася", "Ворона", 3);
        shop.buy("Вася", "Сокол", 1);
        shop.buy("Вася", "Утка", 23);

        System.out.println("Продано " + shop.getSoldBirdsCount("Утка") + " уток на сумму " + shop.getSoldBirdsTotal("Утка"));
        System.out.println("На складе меньше 3-х штук: " + String.join(", ", shop.getBirdsWithStockLessThan(3)));
        System.out.println("Всего продано на сумму: " + shop.getTransactionsTotal());
    }
}
