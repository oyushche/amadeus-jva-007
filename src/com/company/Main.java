package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import static java.lang.System.currentTimeMillis;

public class Main
{

    public static void main(String[] args)
    {
        Store store = new Store();
        Bird sparrow = new Bird("Sparrow");
        Bird parrot = new Bird("Parrot");
        Customer ivanovCustomer = new Customer("Ivanov");
        Customer petrovCustomer = new Customer("Petrov");

        store.addBird(sparrow, 3, 2);
        store.addBird(parrot, 1, 2);


        store.buy(sparrow, 1, petrovCustomer, new Date(currentTimeMillis() - 24 * 3600 * 1000 * 20));
        store.buy(sparrow, 2, ivanovCustomer, new Date(currentTimeMillis()));


        // 1. Получить продажи по конкретной птице
        // а. сколько штук
        System.out.println("1.a. Bought number for 'sparrow': " + store.birdBoughtNumber(sparrow));
        // б. сколько денег
        System.out.println("1.b. Profit for 'sparrow': " + store.birdProfit(sparrow));

        // 2. Каких птиц на складе меньше 3-х штук
        System.out.println("2. Birds number less than 3: " + store.birdNumberLessThan(3));

        // 3. Сколько денег я вообще заработал
        System.out.println("3.a. Total profit: " + store.totalProfit());
        // "сколько денег заработал за последние 7 дней"
        System.out.println("3.b. Total week profit: " + store.totalWeekProfit());

        // 4. & 5.:
        HashMap<Customer, Store.CustomerStats> stats = store.customersStats();

        // 4. Вывести список покупателей отсортирован по количеству потраченных денег
        ArrayList<Store.CustomerStats> moneyStats = store.customersStatsBySpentMoney(stats);

        System.out.println("4. Customers by spent money:");
        for (Iterator iterator = moneyStats.iterator(); iterator.hasNext();) {
            Store.CustomerStats item = (Store.CustomerStats) iterator.next();
            System.out.println(item.customer.name + "(" + item.sum + ")");
        }

        // 5. Вывести список покупателей отсортирован по количеству совершённых покупок
        System.out.println("5. Customers by birds bought number:");
        for (Iterator iterator = moneyStats.iterator(); iterator.hasNext();) {
            Store.CustomerStats item = (Store.CustomerStats) iterator.next();
            System.out.println(item.customer.name + "(" + item.number + ")");
        }

        // 6. + необходимые методы для работы магазина
        System.out.println("6. Necessary methods for bird store: " + (store.isStoreOpened() ? "Store is opened" : "Store is closed"));


    }
}
