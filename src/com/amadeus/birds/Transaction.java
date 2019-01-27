package com.amadeus.birds;

import com.amadeus.shared.AbstractProduct;

import java.security.InvalidParameterException;
import java.util.*;

import static java.lang.System.currentTimeMillis;

public class Transaction {
    private String id;
    private ProductBasket<AbstractProduct> basket;
    private Customer customer;
    private MarketStock stock;

    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }

    private Date date;

    public Transaction(Customer customer, ProductBasket<AbstractProduct> basket, MarketStock stock) {
        this.id = UUID.randomUUID().toString();
        this
            .setCustomer(customer)
            .setBasket(basket)
            .setStock(stock)
            .setDate(new Date(currentTimeMillis()))
        ;

        this.removeProductsFromStock();
    }

    public MarketStock getStock() {
        return stock;
    }

    public Transaction setStock(MarketStock stock) {
        this.stock = stock;

        return this;
    }

    public String getId() {
        return id;
    }

    protected boolean removeProductsFromStock() throws RuntimeException {
        Set entries = basket.getItems().entrySet();
        Iterator iter = entries.iterator() ;

        try {
            while(iter.hasNext()) {
                Map.Entry<AbstractProduct, Integer> entry = (Map.Entry)iter.next();
                stock.removeItems(entry.getKey(), entry.getValue());
            }
        } catch (InvalidParameterException e) {
            throw new RuntimeException("Not enough products in market");
        }

        return true;
    }

    public double getTotal() {
        int total = 0;

        Set entries = basket.getItems().entrySet();
        Iterator iter = entries.iterator() ;

        while(iter.hasNext()) {
            Map.Entry<AbstractProduct, Integer> entry = (Map.Entry)iter.next();
            total += entry.getKey().getPrice();
        }

        // TODO WHY ?
        //    for(Map.Entry<AbstractProduct, Integer> entry: basket.getItems().entrySet()) {
        //        total += entry.getKey().getPrice();
        //    }

        return total;
    }

    public int getItemsCount() {
        return basket.getItemsCount();
    }

    public ProductBasket getBasket() {
        return basket;
    }

    public Transaction setBasket(ProductBasket<AbstractProduct> basket) {
        this.basket = basket;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Transaction setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
