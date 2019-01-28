package com.amadeus.birds;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(" ==== Bird shop ====");

        BirdShop demoBirdshop = new BirdShop();

        Bird duck = new Bird("duck");
        Bird eagle = new Bird("eagle");
        Bird albatros = new Bird("albatros");

        Client peter = new Client("Peter");
        Client olga = new Client("Olga");
        Client anna = new Client("Anna");

        demoBirdshop.buy(duck, 10.0, 5, peter);
        demoBirdshop.buy(eagle, 300.0, 3, peter);
        demoBirdshop.buy(duck, 15.0, 10, peter);
        demoBirdshop.buy(albatros, 40.0, 4, peter);

        demoBirdshop.sell(duck, 100.0, 1, peter);
        demoBirdshop.sell(duck, 50.0, 8, anna); // из двух партий с разной себестоимостью
        demoBirdshop.sell(eagle, 1000.0, 5, olga); // попытка продажи больше чем есть на складе
        demoBirdshop.sell(albatros, 250.0, 2, olga);
        demoBirdshop.sell(albatros, 100.0, 1, anna);
        demoBirdshop.sell(duck, 3.0, 1, anna);

        demoBirdshop.printTransactions();

        System.out.println(duck+" profit = "+demoBirdshop.profit(duck));
        System.out.println(anna+" profit = "+demoBirdshop.profit(anna));
        System.out.println(olga+" profit = "+demoBirdshop.profit(olga));
        System.out.println(duck+" rest = "+demoBirdshop.rest(duck));
        System.out.println(eagle+" rest = "+demoBirdshop.rest(eagle));
        System.out.println("total profit = "+demoBirdshop.totalProfit());
        System.out.println("rest less than 3 = "+demoBirdshop.fewRest(3));
        System.out.println("top clients : "+demoBirdshop.topClients());
        System.out.println("top clients by dial: "+demoBirdshop.topClientsByDeal());

    }
}
