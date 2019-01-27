import com.amadeus.birds.*;
import com.amadeus.shared.AbstractProduct;

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

        market
            .addCustomer(customer1)
            .addCustomer(customer2)
        ;

        customer1.addProductToBasket(crow, 1);
        customer1.addProductToBasket(duck, 1);
        customer2.addProductToBasket(eagle, 2);
        customer2.addProductToBasket(duck, 3);

        System.out.println("Products in stock: " + stock.getItemsCount());
        customer1.buyProducts(market);
        customer2.buyProducts(market);
        System.out.println("Products left in stock: " + stock.getItemsCount());
    }
}
