package com.amadeus.birds;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addBird("Ворона", 1);
        shop.addBird("Сокол", 5);
        shop.addBird("Утка", 0.5);

        shop.addStock("Ворона", 100);
        shop.addStock("Сокол", 40);
        shop.addStock("Утка", 50);

        shop.buy("Вася", "Ворона", 1);
        shop.buy("Вася", "Сокол", 2);
        shop.buy("Вася", "Утка", 3);
        shop.buy("Вася", "Утка", 1);

        shop.buy("Петя", "Ворона", 10);
        shop.buy("Петя", "Сокол", 20);
        shop.buy("Петя", "Утка", 30);

        shop.buy("Боря", "Утка", 1);

        System.out.println("Продано " + shop.getSoldBirdsCount("Утка") + " уток на сумму " + shop.getSoldBirdsTotal("Утка"));
        System.out.println("На складе меньше 3-х штук: " + String.join(", ", shop.getBirdsWithStockLessThan(3)));
        System.out.println("Всего продано на сумму: " + shop.getTransactionsTotal());
        System.out.println("Клиенты по суммам: " + String.join(", ", shop.sortClientsByMoney()));
        System.out.println("Клиенты по количеству покупок: " + String.join(", ", shop.sortClientsByTransactionsCount()));
    }
}
