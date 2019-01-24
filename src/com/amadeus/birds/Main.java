package com.amadeus.birds;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();

        for (int i = 0; i < 20; i++) {
            store.add(new Crow());
        }
        for (int i = 0; i < 23; i++) {
            store.add(new Falcon());
        }
        for (int i = 0; i < 4; i++) {
            store.add(new Duck());
        }

        printStoreDetails(store);


        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addList(store.cropListByType(IBird.CROW, 3));
        shoppingCart.addList(store.cropListByType(IBird.FALCON, 1));
        shoppingCart.addList(store.cropListByType(IBird.DUCK, 23));

        printShoppingCartDetails(shoppingCart);
        printStoreDetails(store);
    }

    public static void printStoreDetails(Store store)
    {
        System.out.println("----------------------------------");
        System.out.println("Store size: " + store.getSize());
        System.out.println("Total price for all birds in store: " + store.getTotalPrice());
        for (String type : new String[]{IBird.DUCK, IBird.CROW, IBird.FALCON}) {
            System.out.println("Item " + type + " in store: " + store.getSizeByType(type));
            System.out.println("Total price for all " + type + " in store: " + store.getTotalPriceByType(type));
        }
    }


    public static void printShoppingCartDetails(ShoppingCart shoppingCart)
    {
        System.out.println("----------------------------------");
        System.out.println("Cart size: " + shoppingCart.getSize());
        System.out.println("Total price for all birds in cart: " + shoppingCart.getTotalPrice());
        for (String type : new String[]{IBird.DUCK, IBird.CROW, IBird.FALCON}) {
            System.out.println("Item " + type + " in cart: " + shoppingCart.getSizeByType(type));
            System.out.println("Total price for all " + type + " in cart: " + shoppingCart.getTotalPriceByType(type));
        }
    }

}
