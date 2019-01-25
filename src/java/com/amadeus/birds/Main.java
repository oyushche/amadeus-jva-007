package java.com.amadeus.birds;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        MarketStock stock = new MarketStock();

        stock.addItems(new Bird("crow"), 20);
        stock.addItems(new Bird("eagle"), 23);
        stock.addItems(new Bird("duck"), 4);

        Customer customer1 = new Customer("#1", "Vasya", new ProductBasket());
        Customer customer2 = new Customer("#2", "Kolya", new ProductBasket());

//        UUID.randomUUID().toString();
    }
}
