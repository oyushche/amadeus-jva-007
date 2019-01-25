package java.com.amadeus.birds;

import java.util.Map;
import java.util.UUID;

public class Transaction {
    private String id;
    private ProductBasket<Product> basket;
    private Customer customer;

    public Transaction(Customer customer, ProductBasket<Product> basket) {
        this.id = UUID.randomUUID().toString();
        this
            .setCustomer(customer)
            .setBasket(basket)
        ;


    }

    public String getId() {
        return id;
    }

//    public double getTotal() {
//        return total;
//    }

//    public int getItemsCount() {
////        return itemsCount;
//    }

    public ProductBasket<Product> getBasket() {
        return basket;
    }

    public Transaction setBasket(ProductBasket<Product> basket) {
        this.basket = basket;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Transaction setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
