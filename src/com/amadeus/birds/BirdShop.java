package com.amadeus.birds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class BirdShop {
    private List<Transaction> transactions;
    private Stock stock = new Stock();

    public BirdShop() {
        transactions = new ArrayList<>();
    }
    public void buy(Bird bird, Client provider, Integer amount, Double cost){
        Transaction t = new Transaction(bird, provider, amount, cost);
        transactions.add(t);
    }
    public void sell(Bird bird, Client customer, Integer amount, Double cost){
        Transaction t = new Transaction(bird, customer, amount, cost, stock.sellBirds(bird.getName(),amount));
        transactions.add(t);
    }
    public Integer rest(Bird bird){
        Integer result = 0;
        for (Transaction t:transactions ) {
            if (t.getBird() == bird) {
                if (t.isType()) {
                    result = result + t.getAmount();
                }
                else {result = result - t.getAmount();}

            }
        }
        return result;
    }
    public Double profit(Bird bird){
        Double result = 0.0;
        for (Transaction transaction : transactions) {
            if(transaction.getBird() == bird) {

            }
        }
        return result;
    }
    public void printTransactionList(){
        for (Transaction t:transactions) {
            System.out.println(t);
        }
    }

}
