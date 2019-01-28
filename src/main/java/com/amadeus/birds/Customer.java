package com.amadeus.birds;

import com.amadeus.shared.AbstractProduct;

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

    public Customer addProductToBasket(AbstractProduct product, int count) {
        basket.addItems(product, count);

        return this;
    }

    public Customer removeProductFromBasket(AbstractProduct product) {
        basket.removeAllItems(product);

        return this;
    }

    public Customer clearBasket() {
        basket.removeAllItems();

        return this;
    }

    public void buyProducts(Market market) {
        market.sellProducts(this);
    }
}
