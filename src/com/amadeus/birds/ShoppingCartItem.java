package com.amadeus.birds;

public class ShoppingCartItem implements IShoppingCartItem {

    private Bird bird;

    public ShoppingCartItem(Bird bird)
    {
        this.bird = bird;
    }





    @Override
    public String getUuid() {
        return null;
    }
}
