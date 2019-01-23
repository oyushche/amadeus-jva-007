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
        Iterator<Bird> itr = this.BirdList.iterator();
        int counter = 0;
        for(Bird birdItem:this.BirdList)
        {
            if (birdItem.getType() == type) {
                counter++;
            }
        }
        return counter;
    }

}
