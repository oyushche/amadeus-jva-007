package com.amadeus.birds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

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

    public int getSoldBirdsCount(String birdName) {
        int count = 0;

        for (Transaction transaction: this.transactions) {
            if (transaction.getBirdName().equals(birdName)) {
                count += transaction.getCount();
            }
        }

        return count;
    }

    public double getSoldBirdsTotal(String birdName) {
        double total = 0;

        for (Transaction transaction: this.transactions) {
            if (transaction.getBirdName().equals(birdName)) {
                total += transaction.getPrice() * transaction.getCount();
            }
        }

        return total;
    }

    public String[] getBirdsWithStockLessThan(int count) {
        ArrayList<String> result = new ArrayList<>();

        for (String key: this.stock.keySet()) {
            if (this.stock.get(key) < count) {
                result.add(key);
            }
        }

        return result.toArray(new String[0]);
    }

    public double getTransactionsTotal() {
        double total = 0;

        for (Transaction transaction: this.transactions) {
            total += transaction.getTotal();
        }

        return total;
    }

    public String[] sortClientsByMoney() {
        HashMap<String, Double> clientTotals = new HashMap<>();

        for (Transaction transaction: this.transactions) {
            clientTotals.put(transaction.getClient(), clientTotals.getOrDefault(transaction.getClient(), 0.0) + transaction.getTotal());
        }

        TreeMap<String, Double> sorted = new TreeMap<>(new ValueComparator<>(clientTotals));
        sorted.putAll(clientTotals);

        return sorted.keySet().toArray(new String[0]);
    }

    public String[] sortClientsByTransactionsCount() {
        HashMap<String, Integer> clientCounts = new HashMap<>();

        for (Transaction transaction: this.transactions) {
            clientCounts.put(transaction.getClient(), clientCounts.getOrDefault(transaction.getClient(), 0) + 1);
        }

        TreeMap<String, Integer> sorted = new TreeMap<>(new ValueComparator<>(clientCounts));
        sorted.putAll(clientCounts);

        return sorted.keySet().toArray(new String[0]);
    }
}
