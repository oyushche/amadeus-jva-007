package com.amadeus.birds;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    public ArrayList<Bird> BirdList = new ArrayList<Bird>();


    public int getSize()
    {
        return this.BirdList.size();
    }

    public void add(Bird bird)
    {
        this.BirdList.add(bird);
    }

    public int getSizeByType(String type)
    {
        int counter = 0;
        for(Bird birdItem:this.BirdList)
        {
            if (birdItem.getType() == type) {
                counter++;
            }
        }
        return counter;
    }

    public float getTotalPriceByType(String type)
    {
        float total = 0;
        for(Bird birdItem:this.BirdList)
        {
            if (birdItem.getType() == type) {
                total += birdItem.getPrice();
            }
        }
        return total;
    }


    public float getTotalPrice()
    {
        float total = 0;
        for(Bird birdItem:this.BirdList)
        {
            total += birdItem.getPrice();
        }
        return total;
    }



    public void addList(ArrayList<Bird> BirdList){
        this.BirdList.addAll(BirdList);
    }
}
