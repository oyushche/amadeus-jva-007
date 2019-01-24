package com.amadeus.birds;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("=====  Bird shop ====");
        BirdShopDemo birdShop = new BirdShopDemo();
        Bird eagle = new Bird("eagle");
        Bird albatross = new Bird("albatross");
        Bird chichken = new Bird("chicken");
        Client ivan = new Client("Ivan");
        Client peter = new Client("Peter");
        Client anna  = new Client("Anna");
        birdShop.buy(eagle,ivan,5, 10.0);
        birdShop.buy(albatross,peter,3, 30.0);
        birdShop.sell(eagle,anna,1,5.0);
        birdShop.printTransactionList();

    }
}
