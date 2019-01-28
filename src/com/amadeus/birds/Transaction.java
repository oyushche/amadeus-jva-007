package com.amadeus.birds;

public class Transaction {
    private int type; // +1 incoming, -1 selling
    private Bird bird;
    private Client client;
    private Integer amount;
    private Double cost;
    private Double netCost;

    public Transaction(int type, Bird bird, Client client, Integer amount, Double cost, Double netCost) {
        this.type = type;
        this.bird = bird;
        this.client = client;
        this.amount = amount;
        this.cost = cost;
        this.netCost = netCost;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public Double getNetCost() {
        return netCost;
    }

    public void setNetCost(Double netCost) {
        this.netCost = netCost;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type= " + type +
                ", " + bird +
                ", " + client +
                ", amount= " + amount +
                ", cost= " + cost +
                ", netCost= " + netCost +
                '}';    }
}
