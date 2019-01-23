package com.amadeus.birds;

public class Transaction {
    private String client;
    private BirdType product;
    private int count;

    public Transaction(String client, BirdType product, int count) {
        this.client = client;
        this.product = product;
        this.count = count;
    }

    public String getClient() {
        return this.client;
    }

    public BirdType getProduct() {
        return this.product;
    }

    public int getCount() {
        return this.count;
    }
}
