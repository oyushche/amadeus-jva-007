package java.com.amadeus.birds;

import java.util.ArrayList;

public class Market {
    private MarketStock stock;
    private ProductBasket basket;
    private ArrayList<Customer> customers;

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void sellProducts(Customer customer) {
        int idx = customers.indexOf(customer);
        if(idx != -1) {
            Transaction transaction = new Transaction(customer, customer.getBasket());
//            transaction.getTotal()
        }
    }
}
