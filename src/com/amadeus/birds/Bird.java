package com.amadeus.birds;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class Bird {
    private String name;


    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird(" + name + ")";
    }

}
