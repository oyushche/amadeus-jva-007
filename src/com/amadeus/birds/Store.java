package com.amadeus.birds;

public class Store {
    private Warehouse StoreWarehouse;
    private Purchase StorePurchases;

    Store()
    {
        this.StoreWarehouse = new Warehouse();
        this.StorePurchases = new Purchase(this.StoreWarehouse);

        this.StoreWarehouse.add("eagle", 57, 2.3);
        this.StoreWarehouse.add("eagle", 37, 2.4);
        this.StoreWarehouse.add("eagle", 57, 2.3);
        this.StoreWarehouse.add("eagle", 57, 2.3);
        this.StoreWarehouse.add("crow", 32, 2.0);
        this.StoreWarehouse.add("duck", 69, 3.1);

        this.StorePurchases.make(1, 33, "Rich Eaglebuyer");
        this.StorePurchases.make(0, 15, "Poor Eaglebuyer");
        this.StorePurchases.make(1, 3, "Poor Eaglebuyer");
        this.StorePurchases.make(0, 11, "Rich Eaglebuyer");
        this.StorePurchases.make(0, 2, "Fernando Torres");
        this.StorePurchases.make(0, 35, "John Doe");
        this.StorePurchases.make(0, 75, "John Doe");
        this.StorePurchases.make(3, 12, "John Doe");
        this.StorePurchases.make(2, 30, "John Doe");
        this.StorePurchases.make(0, 5, "Megan Fox");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Eagle_2.3 Profit: \u001B[32m" + this.StorePurchases.getProfitByProductId(0) + "$\u001B[0m");
        System.out.println("Eagle_2.3 Amount Sold: \u001B[34m" + this.StorePurchases.getAmountSoldByProductId(0) + "\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Eagle_2.4 Profit: \u001B[32m" + this.StorePurchases.getProfitByProductId(1) + "$\u001B[0m");
        System.out.println("Eagle_2.4 Amount Sold: \u001B[34m" + this.StorePurchases.getAmountSoldByProductId(1) + "\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Crow_2.0 Profit: \u001B[32m" + this.StorePurchases.getProfitByProductId(2) + "$\u001B[0m");
        System.out.println("Crow_2.0 Amount Sold: \u001B[34m" + this.StorePurchases.getAmountSoldByProductId(2) + "\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Duck_3.1 Profit: \u001B[32m" + this.StorePurchases.getProfitByProductId(3) + "$\u001B[0m");
        System.out.println("Duck_3.1 Amount Sold: \u001B[34m" + this.StorePurchases.getAmountSoldByProductId(3) + "\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Left less than 3: \u001B[31m" + this.StoreWarehouse.getWaresWhereQuantityLessThan(3) + "\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Overall Profit: \u001B[32m" + this.StorePurchases.getProfit() + "$\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Customers by spent money: \u001B[32m" + this.StorePurchases.getCustomersBySpentMoney() + "\u001B[0m");

        System.out.println("\u001B[32m--------------------------------------------\u001B[0m");
        System.out.println("Customers by orders amount: \u001B[32m" + this.StorePurchases.getCustomersByOrdersNumber() + "\u001B[0m");
    }
}
