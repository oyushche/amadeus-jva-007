package com.amadeus.birds;

import java.util.*;

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
    public Integer sales(Bird bird){
        Integer result = 0;
        for (Transaction transaction : transactionList) {
            if (bird == transaction.getBird()) {
                if (transaction.getType() == -1){
                    result += transaction.getAmount();
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
    public Double totalProfit(){
        Double result = 0.0;
        for (Transaction transaction : transactionList) {
            if (transaction.getType() == -1){
                result += transaction.getCost() - transaction.getNetCost();
            }
        }
        return result;
    }
    public List<Bird> fewRest(Integer max) {
        return storage.fewRest(max);
    }
    public List<Client> topClients() {
        List<Client> result = new ArrayList<>();
        Map<Client, Double> counter = new HashMap<>();
        for (Transaction transaction : transactionList) {
            if (transaction.getType() == -1){
                if (counter.containsKey(transaction.getClient())){
                    counter.put(transaction.getClient(), counter.get(transaction.getClient()) + transaction.getCost());
                }
                else{
                    counter.put(transaction.getClient(), transaction.getCost());
                }
            }
        }
        // sorting counter map by value reverse
        List<Map.Entry<Client, Double>> list = new ArrayList<>(counter.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Client, Double> entry : list) {
           result.add(entry.getKey());
        }
        Collections.reverse(result);
        //-------------
        return result;
    }

    public List<Client> topClientsByDeal(){
        List<Client> result = new ArrayList<>();

        Map<Client, Integer> counter = new HashMap<>();
        for (Transaction transaction : transactionList) {
            if (transaction.getType() == -1){
                if (counter.containsKey(transaction.getClient())){
                    counter.put(transaction.getClient(), counter.get(transaction.getClient()) + 1);
                }
                else{
                    counter.put(transaction.getClient(), 1);
                }
            }
        }
        // sorting counter map by value reverse
        List<Map.Entry<Client, Integer>> list = new ArrayList<>(counter.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Client, Integer> entry : list) {
            result.add(entry.getKey());
        }
        Collections.reverse(result);

        return result;
    }

}
