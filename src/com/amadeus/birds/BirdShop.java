package com.amadeus.birds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class BirdShop {
    private List<Transaction> transactionList = new ArrayList<>();
    private Storage storage = new Storage();

    public void buy(Bird bird, Double cost, Integer amount, Client provider){
        if (amount > 0) {
            storage.add(bird, cost, amount);
            transactionList.add(new Transaction(1, bird, provider, amount, cost, cost));
        }
    }
    public void sell(Bird bird, Double cost, Integer amount, Client customer){
        if (amount > 0) {
            Map<String, Object> res = storage.remove(bird, amount);
            Integer sellAmount = (Integer) res.get("amount");
            if (sellAmount > 0) {
                Double sellCost = cost;
                if (! sellAmount.equals(amount)) {
                    sellCost = cost/amount * sellAmount;
                }
                transactionList.add(new Transaction(-1, bird, customer, sellAmount, sellCost, (Double) res.get("netCost")));

            }
        }
    }

    public Double profit(Bird bird) {
        Double result = 0.0;
        for (Transaction transaction : transactionList) {
            if (bird == transaction.getBird()) {
                if (transaction.getType() == -1){
                    result += transaction.getCost() - transaction.getNetCost();
                }
            }
        }
        return result;
    }
    public Double profit(Client client){
        Double result = 0.0;
        for (Transaction transaction : transactionList) {
            if (client == transaction.getClient()) {
                if (transaction.getType() == -1){
                    result += transaction.getCost() - transaction.getNetCost();
                }
            }
        }
        return result;
    }
    public void printTransactions() {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);

        }
    }
    public void printStorage() {
        storage.printStorsge();
    }

    public Integer rest(Bird bird){
        return storage.rest(bird);
    }

}
