package com.amadeus.birds;

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

        demoBirdshop.printStorage();

        demoBirdshop.sell(duck, 50.0, 8, anna);
        demoBirdshop.sell(eagle, 1000.0, 5, olga);
        demoBirdshop.sell(albatros, 250.0, 3, olga);
        demoBirdshop.sell(albatros, 100.0, 1, anna);

        demoBirdshop.printStorage();

        demoBirdshop.printTransactions();

        System.out.println(duck+" profit = "+demoBirdshop.profit(duck));
        System.out.println(anna+" profit = "+demoBirdshop.profit(anna));
        System.out.println(olga+" profit = "+demoBirdshop.profit(olga));
        System.out.println(duck+" rest = "+demoBirdshop.rest(duck));
        System.out.println(eagle+" rest = "+demoBirdshop.rest(eagle));

    }
}
