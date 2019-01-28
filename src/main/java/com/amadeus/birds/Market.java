package com.amadeus.birds;

import com.amadeus.shared.AbstractProduct;
import com.amadeus.shared.AbstractStorage;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        System.out.println("-------------------");
        System.out.println("Products total " + transaction.getTotal());
        System.out.println("Products count " + transaction.getItemsCount());

        System.out.println("Products:");
        Set entries = transaction.getBasket().getItems().entrySet();
        Iterator iter = entries.iterator();

        while(iter.hasNext()) {
            Map.Entry<AbstractProduct, Integer> entry = (Map.Entry)iter.next();
            System.out.println("\t" + entry.getKey());
        }

        System.out.println("-------------------");
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

    public static Predicate<Transaction> areOlderThan(LocalDateTime periodStart) {
        return p -> p.getDate().isAfter(periodStart);
    }

    public static ArrayList<Transaction> filterTransactions (ArrayList<Transaction> transactions, Predicate<Transaction> predicate) {
        return (ArrayList<Transaction>) transactions.stream()
            .filter(predicate)
            .collect(Collectors.<Transaction>toList())
        ;
    }

    public double getMoneyEarnings() {
        return transactions
            .stream()
            .mapToDouble(t -> t.getTotal())
            .sum()
        ;
    }

    public double getMoneyEarnings(int daysPeriod) {
        LocalDateTime localDate = LocalDateTime.now();
        LocalDateTime periodStart = localDate.minusDays(daysPeriod);

        return filterTransactions(transactions, areOlderThan(periodStart))
            .stream()
            .mapToDouble(t -> t.getTotal())
            .sum()
        ;
    }

    public double getMoneyEarnings(int daysPeriod, AbstractProduct product) {
        LocalDateTime localDate = LocalDateTime.now();
        LocalDateTime periodStart = localDate.minusDays(daysPeriod);

        return filterTransactions(transactions, areOlderThan(periodStart))
            .stream()
            .mapToDouble(t -> t.getTotal(product))
            .sum()
        ;
    }

    public List<String> getProductsInstockLessThan(int lessThan)
    {
        ArrayList<String> products = new ArrayList<String>();

        Set entries =  AbstractStorage.filterByValue(stock.getItems(), AbstractStorage.itemsLessThan(lessThan)).entrySet();
        Iterator iter = entries.iterator();

        while(iter.hasNext()) {
            Map.Entry<AbstractProduct, Integer> entry = (Map.Entry)iter.next();
            products.add(entry.getKey().getTitle());
        }

        return products;
    }
}
