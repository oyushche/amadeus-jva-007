package com.amadeus.birds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kysliakovskyi on 25.01.2019.
 */
public class Stock {
    private List<Bird> birdsArray = new ArrayList<>();

    public void addBirds(Bird bird, Integer amount){
        for (int i = 0; i < amount; i++) {
            birdsArray.add(bird);
        }
    }

    public Double sellBirds(String birdName, Integer amount){
        Integer restAmount = amount;
        Double netCost = 0.0;
        for (Bird bird : birdsArray) {
            if (bird.getName().equals(birdName) && (restAmount > 0) ) {
                restAmount--;
                netCost = netCost + bird.getPrice();
                birdsArray.remove(bird);
            }
            if (restAmount == 0) {
                return netCost;
            }
        }
        return netCost;
    }

}
