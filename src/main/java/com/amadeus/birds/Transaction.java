package main.java.com.amadeus.birds;

import main.java.com.amadeus.shared.AbstractProduct;

import java.security.InvalidParameterException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.currentTimeMillis;

public class Transaction {
    private String id;
    private ProductBasket<AbstractProduct> basket;
    private Customer customer;
    private MarketStock stock;
    private LocalDateTime date;

    public Transaction(Customer customer, ProductBasket<AbstractProduct> basket, MarketStock stock) {
        this.id = UUID.randomUUID().toString();
        this
            .setCustomer(customer)
            .setBasket(basket)
            .setStock(stock)
            .setDate(LocalDateTime.now())
        ;

        this.removeProductsFromStock();
    }

    public Transaction setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
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
            total += entry.getKey().getPrice() * entry.getValue();
        }

        // TODO WHY ?
        //    for(Map.Entry<AbstractProduct, Integer> entry: basket.getItems().entrySet()) {
        //        total += entry.getKey().getPrice();
        //    }

        return total;
    }

    public double getTotal(AbstractProduct product) {
        int total = 0;

        Set entries = basket.getItems().entrySet();
        Iterator iter = entries.iterator() ;

        while(iter.hasNext()) {
            Map.Entry<AbstractProduct, Integer> entry = (Map.Entry)iter.next();
            if(entry.getKey() == product) {
                total += entry.getKey().getPrice() * entry.getValue();
            }
        }

        return total;
    }

    public int getItemsCount() {
        return basket.getItemsCount();
    }

    public double getItemsCount(AbstractProduct product) {
        return basket.getItemsCount(product);
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
