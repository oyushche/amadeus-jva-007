package com.amadeus.birds;

public class Main
{

    public static void main(String[] args)
    {

        Store store = new Store();

        for (int i = 0; i < 20; i++) {
            store.add(new Crow());
        }
        for (int i = 0; i < 23; i++) {
            store.add(new Falcon());
        }
        for (int i = 0; i < 4; i++) {
            store.add(new Duck());
        }

        System.out.println("Store size: " + store.getSize());


        for(String type:new String[]{IBird.DUCK, IBird.CROW, IBird.FALCON})
        {
            System.out.println("Item "+type+" in store: " + store.getSizeByType(type));

        }



    }
}
