package com.amadeus.birds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kysliakovskyi on 28.01.2019.
 */
public class Storage {
    class StoredBird {
        private Bird bird;
        private Double price;

        public Bird getBird() {
            return bird;
        }

        public void setBird(Bird bird) {
            this.bird = bird;
        }

        @Override
        public String toString() {
            return "StoredBird{" +
                    "" + bird +
                    ", price=" + price +
                    '}';
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public StoredBird(Bird bird, Double price) {
            this.bird = bird;
            this.price = price;
        }
    }

    private List<StoredBird> birdStore = new ArrayList<>();

    public void add(Bird bird, Double cost, Integer amount){

        Double price = cost/amount;
        for (int i = 0; i < amount; i++) {
            StoredBird newBird = new StoredBird(bird, price);
            birdStore.add(newBird);
        }
    }

    public Map<String, Object> remove(Bird bird, Integer amount){
        Map<String, Object> result = new HashMap<>();
        result.put("netCost", 0.0);
        result.put("amount",  0);
        Double netCost = 0.0;
        Integer restOfAmount = amount;
        List<StoredBird> forRemove = new ArrayList<>();
        for (StoredBird storedBird : birdStore) {
            if (storedBird.getBird() == bird) {
                netCost += storedBird.getPrice();
                restOfAmount--;
                forRemove.add(storedBird);
            }
            if (restOfAmount == 0) {
                break;
            }
        }
        birdStore.removeAll(forRemove);
        result.put("netCost", netCost);
        result.put("amount", amount - restOfAmount);

        return result;
    }
    public Integer rest(Bird bird){
        Integer result = 0;
        for (StoredBird storedBird : birdStore) {
            if (storedBird.getBird() == bird){
                result++;
            }
        }
        return result;
    }
    public void printStorsge(){
        System.out.println("current storage:");
        for (StoredBird storedBird : birdStore) {
            System.out.print(storedBird+"->");
        }
        System.out.println();
    }
}
