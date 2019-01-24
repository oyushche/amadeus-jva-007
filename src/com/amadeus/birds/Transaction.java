package com.amadeus.birds;

import java.awt.geom.Arc2D;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class Transaction {
    private boolean type;
    private Bird bird;
    private Client client;
    private Integer amount;
    private Double cost;

    public Transaction(boolean type, Bird bird, Client client, Integer amount, Double cost) {
        this.type = type;
        this.bird = bird;
        this.client = client;
        this.amount = amount;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", bird=" + bird +
                ", client=" + client +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
