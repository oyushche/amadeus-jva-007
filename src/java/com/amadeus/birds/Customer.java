package java.com.amadeus.birds;

public class Customer {
    private String id;
    private String name;
    private ProductBasket basket;

    public Customer(String id, String name, ProductBasket basket) {
        this.id = id;
        this.name = name;
        this.basket = basket;
    }

    public ProductBasket getBasket() {
        return basket;
    }

    public Customer addProductToBasket(Product product, int count) {
        basket.addItems(product, count);

        return this;
    }

    public Customer removeProductFromBasket(Product product) {
        basket.removeAllItems(product);

        return this;
    }

    public Customer clearBasket() {
        basket.removeAllItems();

        return this;
    }

    public void buyProducts() {

    }
}
