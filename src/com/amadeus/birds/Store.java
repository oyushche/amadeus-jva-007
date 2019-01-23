package com.amadeus.birds;

import java.util.ArrayList;

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


}
