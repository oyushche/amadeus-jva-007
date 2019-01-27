package com.company;

import java.util.*;

import static java.lang.System.currentTimeMillis;

public class Store {
    // Instance Variables
    ArrayList<StoreItem> items = new ArrayList<StoreItem>();

    ArrayList<HistoryItem> history = new ArrayList<HistoryItem>();

    enum Column {
        NUM, SUM
    }

    class CustomerStats implements Comparable<CustomerStats>  {
        Customer customer;
        int number;
        int sum;
        Column compareColumn = Column.SUM;

        public CustomerStats(Customer customer, int number, int sum) {
            this.customer = customer;
            this.number = number;
            this.sum = sum;
        }

        public CustomerStats(Customer customer, int number, int sum, Column compareColumn) {
            this.customer = customer;
            this.number = number;
            this.sum = sum;
            this.compareColumn = compareColumn;
        }

        public int compareTo(CustomerStats customerStats) {
            if (compareColumn == Column.NUM) {
                return customerStats.number - number;
            }

            return customerStats.sum - sum;
        }

        public void setCompareColumn(Column compareColumn) {
            this.compareColumn = compareColumn;
        }
    }

    public void addBird(Bird bird, int number, int price) {
        StoreItem storeItem = this.getItemByBird(bird);

        if (storeItem != null) {
            System.out.println("Bird already exists");
            return;
        }


        StoreItem x = new StoreItem(bird, number, price);
        this.items.add(x);



        System.out.println("Added bird");
    }

    public StoreItem getItemByBird(Bird bird) {
        int pos = -1;

        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).bird == bird) {
                pos = i;
            }
        }

        if (pos == -1) {
            return null;
        }

        return this.items.get(pos);
    }

    public void buy(Bird bird, int number, Customer customer, Date date) {
        StoreItem storeItem = this.getItemByBird(bird);

        if (storeItem == null) {
            System.out.println("Bird not found");
            return;
        }

        if (storeItem.number < number) {
            System.out.println("Not enough birds");
            return;
        }
        storeItem.number -= number;
        this.history.add(new HistoryItem(bird, storeItem.price, number, customer, date));

        System.out.println("Bird bought");
    }


    public int birdProfit(Bird bird) {
        int sum = 0;

        for (int i = 0; i < this.history.size(); i++) {
            HistoryItem historyItem = this.history.get(i);
            if (historyItem.bird == bird) {
                sum += historyItem.price * historyItem.number;
            }
        }

        return sum;
    }

    public int totalProfit() {
        int sum = 0;

        for (int i = 0; i < this.history.size(); i++) {
            HistoryItem historyItem = this.history.get(i);
            sum += historyItem.price * historyItem.number;
        }

        return sum;
    }

    public int totalWeekProfit() {
        int sum = 0;

        for (int i = 0; i < this.history.size(); i++) {
            HistoryItem historyItem = this.history.get(i);
            if (historyItem.date.after(new Date(currentTimeMillis() - 7 * 3600 * 1000 * 20))) {
                sum += historyItem.price * historyItem.number;
            }
        }

        return sum;
    }

    public int birdBoughtNumber(Bird bird) {
        int num = 0;

        for (int i = 0; i < this.history.size(); i++) {
            HistoryItem historyItem = this.history.get(i);
            if (historyItem.bird == bird) {
                num++;
            }
        }

        return num;
    }


    public int birdNumberLessThan(int number) {
        int k = 0;

        for (int i = 0; i < this.items.size(); i++) {
            StoreItem storeItem = this.items.get(i);
            if (storeItem.number < number) {
                k++;
            }
        }

        return k;
    }

    public HashMap<Customer, CustomerStats> customersStats() {
        HashMap<Customer, CustomerStats> stats = new HashMap<Customer, CustomerStats>();

        for (int i = 0; i < this.history.size(); i++) {
            HistoryItem item = this.history.get(i);
            if (!stats.containsKey(item.customer)) {
                CustomerStats customerStats = new CustomerStats(item.customer, item.number, item.number * item.price);
                stats.put(item.customer, customerStats);
            } else {
                CustomerStats prevStats = stats.get(item.customer);
                CustomerStats customerStats = new CustomerStats(item.customer, prevStats.number + item.number, prevStats.sum + item.number * item.price);
                stats.put(item.customer, customerStats);
            }
        }

        return stats;
    }

    public static ArrayList<CustomerStats> customersStatsBySpentMoney(HashMap<Customer, CustomerStats> stats) {
        Collection c = stats.values();
        ArrayList<CustomerStats> result = new ArrayList<CustomerStats>();
        for (Iterator iterator = c.iterator(); iterator.hasNext();) {
            CustomerStats item = (CustomerStats) iterator.next();
            item.setCompareColumn(Column.SUM);
            result.add(item);
        }

        Collections.sort(result);

        return result;
    }

    public static ArrayList<CustomerStats> customersStatsByBuysNumber(HashMap<Customer, CustomerStats> stats) {
        Collection c = stats.values();
        ArrayList<CustomerStats> result = new ArrayList<CustomerStats>();
        for (Iterator iterator = c.iterator(); iterator.hasNext();) {
            CustomerStats item = (CustomerStats) iterator.next();
            item.setCompareColumn(Column.NUM);
            result.add(item);
        }

        Collections.sort(result);

        return result;
    }

    public boolean isStoreOpened() {
        return true;
    }
}
