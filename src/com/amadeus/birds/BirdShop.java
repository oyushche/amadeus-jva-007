package com.amadeus.birds;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class BirdShop {
    private HashMap<BirdType, Integer> stock;
    private ArrayList<Transaction> transactions;

    public BirdShop() {
        this.stock = new HashMap<>();
        this.transactions = new ArrayList<>();
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

    public boolean buy(String client, BirdType product, int count)
    {
        if (!this.inStock(product, count)) {
            return false;
        }

        this.transactions.add(new Transaction(client, product, count));
        this.reduceStock(product, count);

        return true;
    }

    public void printStats() {
        HashMap<Pair<String, BirdType>, Integer> stats = new HashMap<>();

        for (Transaction transaction: this.transactions) {
            Pair<String, BirdType> key = new Pair<>(transaction.getClient(), transaction.getProduct());
            int value = transaction.getCount();

            if (stats.containsKey(key)) {
                value += stats.get(key);
            }

            stats.put(key, value);
        }

        for (HashMap.Entry<Pair<String, BirdType>, Integer> item: stats.entrySet()) {
            System.out.println(
                item.getKey().getKey() + ": "
                + item.getValue().toString() + " "
                + item.getKey().getValue() + "'s"
            );
        }
    }
}
