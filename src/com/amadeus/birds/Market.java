package com.amadeus.birds;

import com.amadeus.shared.AbstractProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Market {
    private MarketStock stock;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public MarketStock getStock() {
        return stock;
    }

    public Market setStock(MarketStock stock) {
        this.stock = stock;
        return this;
    }

    public Market addCustomer(Customer customer) {
        customers.add(customer);

        return this;
    }

    public void printCheck(Transaction transaction) {
        System.out.println("Products total " + transaction.getTotal());
        System.out.println("Products count " + transaction.getItemsCount());

        System.out.println("Products:");
        Set entries = transaction.getBasket().getItems().entrySet();
        Iterator iter = entries.iterator();

        while(iter.hasNext()) {
            Map.Entry<AbstractProduct, Integer> entry = (Map.Entry)iter.next();
            System.out.println("\t" + entry.getKey());
        }
    }

    public void sellProducts(Customer customer) {
        int idx = customers.indexOf(customer);
        if(idx == -1) {
            this.addCustomer(customer);
        }

        Transaction transaction = new Transaction(customer, customer.getBasket(), stock);
        this.printCheck(transaction);

        transactions.add(transaction);
    }
}
