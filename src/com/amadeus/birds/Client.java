package com.amadeus.birds;

/**
 * Created by Kysliakovskyi on 24.01.2019.
 */
public class Client {
    @Override
    public String toString() {
        return "Client: " + name + '\'' ;
    }

    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
