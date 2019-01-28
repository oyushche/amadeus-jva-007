package main.java.com.amadeus.birds;

import main.java.com.amadeus.birds.*;
import main.java.com.amadeus.shared.AbstractProduct;
import main.java.com.amadeus.shared.AbstractStorage;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        MarketStock stock = new MarketStock();

        market.setStock(stock);

        AbstractProduct crow = Bird.ProductBuilder.aProduct()
            .withCode("crow")
            .withTitle("Crow")
            .withdCurrency(new Currency().setCode("USD"))
            .withdPrice(20.00)
            .withdDscription("A crow is a bird of the genus Corvus")
            .build()
        ;

        AbstractProduct eagle = Bird.ProductBuilder.aProduct()
            .withCode("eagle")
            .withTitle("Eagle")
            .withdCurrency(new Currency().setCode("USD"))
            .withdPrice(40.00)
            .withdDscription("Eagle is the common name for many large birds of prey of the family Accipitridae")
            .build()
        ;

        AbstractProduct duck = Bird.ProductBuilder.aProduct()
            .withCode("duck")
            .withTitle("Duck")
            .withdCurrency(new Currency().setCode("USD"))
            .withdPrice(15.00)
            .withdDscription("Duck is the common name for a large number of species in the waterfowl family Anatidae")
            .build()
        ;

        stock.addItems(crow, 20);
        stock.addItems(eagle, 23);
        stock.addItems(duck, 4);

        Customer customer1 = new Customer("#1", "Vasya", new ProductBasket<Bird>());
        Customer customer2 = new Customer("#2", "Kolya", new ProductBasket<Bird>());
        Customer customer3 = new Customer("#3", "Petro", new ProductBasket<Bird>());


        customer1.addProductToBasket(crow, 1);
        customer1.addProductToBasket(duck, 1);

        customer2.addProductToBasket(eagle, 2);
        customer2.addProductToBasket(duck, 3);

        customer3.addProductToBasket(crow, 14);
        customer3.addProductToBasket(crow, 3);

        System.out.println("Products in stock: " + stock.getItemsCount());
        customer1.buyProducts(market);
        customer2.buyProducts(market);
        customer3.buyProducts(market);
        System.out.println("Products left in stock: " + stock.getItemsCount());
        System.out.println("Products of type " + crow.getTitle() + " left in stock: " + stock.getItemsCount(crow));

        int daysInterval = 7;
        double earnings = market.getMoneyEarnings(daysInterval);
        System.out.println("Earnings per "  + daysInterval + " days:");
        System.out.println(earnings);

        double earningsByProduct = market.getMoneyEarnings(daysInterval, crow);
        System.out.println("Earnings per "  + daysInterval + " days, by " + crow.getTitle() + " product:");
        System.out.println(earningsByProduct);

        int lessThan = 3;
        System.out.println("Products in stock less than  "  + lessThan + ":");
        System.out.println(market.getProductsInstockLessThan(lessThan));
    }
}
