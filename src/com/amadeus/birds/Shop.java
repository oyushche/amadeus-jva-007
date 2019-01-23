package com.amadeus.birds;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    private HashMap<String, Double> prices;
    private HashMap<String, Integer> stock;
    private ArrayList<Transaction> transactions;

    public Shop() {
        this.prices = new HashMap<>();
        this.stock = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    public void addBird(String birdName, double price) {
        if (this.prices.containsKey(birdName)) {
            throw new RuntimeException("Bird '" + birdName + "' already present in the shop");
        }

        this.prices.put(birdName, price);
        this.stock.put(birdName, 0);
    }

    public int getStock(String birdName) {
        return this.stock.getOrDefault(birdName, 0);
    }

    public boolean inStock(String birdName, int count) {
        if (this.stock.containsKey(birdName)) {
            return this.stock.get(birdName) >= count;
        } else {
            return false;
        }
    }

    public void addStock(String birdName, int count) {
        if (!this.prices.containsKey(birdName)) {
            throw new RuntimeException("Bird '" + birdName + "' is not present in the shop");
        }

        this.stock.put(birdName, this.stock.get(birdName) + count);
    }

    public void reduceStock(String birdName, int count) {
        if (!this.inStock(birdName, count)) {
            throw new RuntimeException("Stock is not enough for '" + birdName + "'");
        }

        this.stock.put(birdName, this.stock.get(birdName) - count);
    }

    public void buy(String client, String birdName, int count)
    {
        if (!this.inStock(birdName, count)) {
            throw new RuntimeException("Stock is not enough for '" + birdName + "'");
        }

        this.transactions.add(new Transaction(client, birdName, this.prices.get(birdName), count));
        this.reduceStock(birdName, count);
    }
}
