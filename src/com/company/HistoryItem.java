package com.company;

import java.util.Date;

public class HistoryItem {
    Bird bird;
    int price;
    int number = 1;
    Date date;
    Customer customer;

    public HistoryItem(Bird bird, int price, int number, Customer customer, Date date) {
        this.bird = bird;
        this.price = price;
        this.number = number;
        this.customer = customer;
        this.date = date;
    }

}
