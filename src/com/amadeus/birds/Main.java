package com.amadeus.birds;

public class Main
{

    public static void main(String[] args)
    {

        Store store = new Store();

        for (int i = 0; i < 20; i++) {
            store.add(new Crow());
        }



        System.out.println("Store size:" + store.getSize());



    }
}
