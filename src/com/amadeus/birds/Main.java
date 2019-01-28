package com.amadeus.birds;

import java.time.LocalDateTime;

public class Main
{
    public static void main(String[] args) {
        Shop myShop = new Shop();

        Client client1 = new Client("Client #1");
        Client client2 = new Client("Client #2");

        for (int i = 0; i < 23; i++) {
            if (i < 4) {
                myShop.addBird(new Bird(BirdType.DUCK, 0.5f));
            }
            if (i < 20) {
                myShop.addBird(new Bird(BirdType.CROW, 1f));
            }
            myShop.addBird(new Bird(BirdType.EAGLE, 5f));
        }

        System.out.println("printBirds:");
        myShop.printBirds();
        System.out.println();

        System.out.println("printBirdLessThan5:");
        myShop.printBirdsLessThan(5);
        System.out.println();

        myShop.setBirdPrice(BirdType.CROW, 2f);

        myShop.buyBird(client1, BirdType.CROW, 3);
        myShop.buyBird(client2, BirdType.EAGLE, 1);
        myShop.buyBird(client2, BirdType.DUCK, 2);

        myShop.printSales(BirdType.DUCK);
        System.out.println();

        myShop.printTotalSales();
        System.out.println();

        System.out.println("printBirds:");
        myShop.printBirds();
        System.out.println();

        System.out.println("printBirdLessThan5:");
        myShop.printBirdsLessThan(5);
        System.out.println();


        myShop.printClientsOrderedByPrice();
        myShop.printClientsOrderedByCount();
        System.out.println();


        System.out.print("Total sales: ");
        System.out.println(myShop.totalSales());
        System.out.print("Yesterday sales: ");
        System.out.println(myShop.totalSales(LocalDateTime.parse("2019-01-27T00:00:00"), LocalDateTime.parse("2019-01-27T23:00:00")));
    }
}
