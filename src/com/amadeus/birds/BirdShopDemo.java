package com.amadeus.birds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class BirdShopDemo {
    private List<Transaction> transactions;

    public BirdShopDemo() {
        transactions = new ArrayList<>();
    }
    public void buy(Bird bird, Client provider, Integer amount, Double cost){

    }
    public void sell(Bird bird, Client customer, Integer amount, Double cost){

    }
    public Integer rest(Bird bird){
        Integer result = 0;
        return result;
    }
    public Double profit(Bird bird){
        Double result = 0.0;
        return result;
    }
    public void printTransactionList(){
        for (Transaction t:transactions) {
            System.out.println(t);
        }
    }

}
