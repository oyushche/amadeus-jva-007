package com.amadeus.birds;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

final public class Store {

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

    public ArrayList<Bird> cropListByType(String type, int quantity)
    {
        ArrayList<Bird> TmpBirdList = new ArrayList<Bird>();

        for(int i = 0; i < this.BirdList.size(); i++)
        {
            Bird birdItem = this.BirdList.get(i);
            if (birdItem.getType() == type) {
                TmpBirdList.add(birdItem);
                this.BirdList.remove(i);
            }
            if (TmpBirdList.size() >= quantity) {
                break;
            }

        }
        return TmpBirdList;
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
}
