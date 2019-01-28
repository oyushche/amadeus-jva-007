package com.amadeus.birds;

import java.time.LocalDateTime;
import java.util.*;

public class Shop
{
    private TreeMap<BirdType, ArrayList<Bird>> birdMap = new TreeMap<BirdType, ArrayList<Bird>>();
    private List<Transaction> transactionList = new ArrayList<Transaction>();


    public void addBird(Bird bird)
    {
        if (!this.birdMap.containsKey(bird.getType())) {
            this.birdMap.put(bird.getType(), new ArrayList<Bird>());
        }

        this.birdMap.get(bird.getType()).add(bird);
    }

    public void setBirdPrice(BirdType type, Float price)
    {
        for (Map.Entry<BirdType, ArrayList<Bird>> entry : this.birdMap.entrySet()) {
            if (entry.getKey() == type) {
                for (Bird bird: entry.getValue()) {
                    bird.setPrice(price);
                }
            }
        }
    }

    public void buyBird(Client client, BirdType type)
    {
        this.buyBird(client, type, 1);
    }

    public void buyBird(Client client, BirdType type, int count)
    {
        if (this.birdMap.containsKey(type) && this.birdMap.get(type).size() >= count) {
            for (int i = 0; i < count; i++) {
                Bird bird = this.birdMap.get(type).remove(0);

                Transaction transaction = new Transaction(client, bird);
                transactionList.add(transaction);
            }
        }
    }

    public float totalSales()
    {
        Float total = 0f;

        for (Transaction transaction : this.transactionList) {
            total += transaction.getBird().getPrice();
        }

        return total;
    }

    public float totalSales(LocalDateTime from, LocalDateTime to)
    {
        Float total = 0f;

        for (Transaction transaction: this.transactionList) {
            if (transaction.getTime().isAfter(from) && transaction.getTime().isBefore(to)) {
                total += transaction.getBird().getPrice();
            }
        }

        return total;
    }

    public void printBirds()
    {
        for (Map.Entry<BirdType, ArrayList<Bird>> entry : this.birdMap.entrySet()) {
            System.out.println(" - " + entry.getKey() + "(count = " + entry.getValue().size() + ")");
        }
    }

    public void printBirdsLessThan(int count)
    {
        for (Map.Entry<BirdType, ArrayList<Bird>> entry : this.birdMap.entrySet()) {
            if (entry.getValue().size() < count) {
                System.out.println(" - " + entry.getKey() + "(count =  " + entry.getValue().size() + ")");
            }
        }
    }

    public void printSales(BirdType type)
    {
        Integer count = 0;
        Float total = 0f;

        for (Transaction transaction: this.transactionList) {
            if (transaction.getBird().getType() == type) {
                count += 1;
                total += transaction.getBird().getPrice();
            }
        }

        System.out.println("printSalesBy" + type + ":");
        System.out.println(" - count = " + count);
        System.out.println(" - total = " + total);
    }

    public void printTotalSales()
    {
        Float total = 0f;

        for (Transaction transaction: this.transactionList) {
            total += transaction.getBird().getPrice();
        }

        System.out.println("printTotalSales: " + total);
    }

    public void printClientsOrderedByPrice()
    {
        TreeMap<String, Float> maps = new TreeMap<String, Float>();

        for (Transaction trans : this.transactionList) {
            String clientName = trans.getClient().getName();

            if (!maps.containsKey(clientName)) {
                maps.put(clientName, new Float(0f));
            }

            maps.put(clientName, maps.get(clientName).floatValue() + trans.getBird().getPrice());
        }

        maps.entrySet().stream().sorted((o1, o2) -> -o1.getValue().compareTo(o2.getValue())).forEach(System.out::println);
    }

    public void printClientsOrderedByCount()
    {
        TreeMap<String, Integer> maps = new TreeMap<String, Integer>();

        for (Transaction trans : this.transactionList) {
            String clientName = trans.getClient().getName();

            if (!maps.containsKey(clientName)) {
                maps.put(clientName, new Integer(0));
            }

            maps.put(clientName, maps.get(clientName).intValue() + 1);
        }

        maps.entrySet().stream().sorted((o1, o2) -> -o1.getValue().compareTo(o2.getValue())).forEach(System.out::println);
    }
}
