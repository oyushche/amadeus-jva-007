package com.amadeus.birds;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("=====  Bird shop ====");
        BirdShop birdShopDemo = new BirdShop();

        Bird eagle = new Bird("eagle");
        Bird albatross = new Bird("albatross");
        Bird chichken = new Bird("chicken");

        Client ivan = new Client("Ivan");
        Client peter = new Client("Peter");
        Client anna  = new Client("Anna");

        birdShopDemo.buy(eagle,ivan,5, 10.0);
        birdShopDemo.buy(albatross,peter,3, 30.0);
        birdShopDemo.sell(eagle,anna,1,5.0);

        birdShopDemo.printTransactionList();

        System.out.println("rest "+eagle+" = "+birdShopDemo.rest(eagle));
        System.out.println("prifit "+eagle+" = "+birdShopDemo.profit(eagle));

    }
}
