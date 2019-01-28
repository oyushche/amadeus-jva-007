package com.amadeus.birds;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Ware> wares;

    private class Ware {
        private String name;

        private Integer quantity;

        private Double price;

        public Ware setName(String name) {
            this.name = name;

            return this;
        }

        public Ware setQuantity(Integer quantity) {
            this.quantity = quantity;

            return this;
        }

        public Ware setPrice(Double price) {
            this.price = price;

            return this;
        }

        public String getName() {
            return name;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Double getPrice() {
            return price;
        }
    }

    Warehouse() {
        this.wares = new ArrayList<>();
    }

    public Warehouse add(String name, Integer quantity, Double price) {
        Ware ware = new Ware();
        ware.setName(name).setQuantity(quantity).setPrice(price);

        if (this.contains(ware)) {
            Ware w = this.wares.get(this.indexOf(ware));

            w.setQuantity(w.getQuantity() + quantity);

            return this;
        }

        this.wares.add(ware);

        return this;
    }

    public Ware getWareById(Integer id) {
        return this.wares.get(id);
    }

    public Integer getQuantityByWareId(Integer id) {
        try {
            Ware ware = this.getWareById(id);

            return ware.getQuantity();
        } catch (Throwable t) {
            return 0;
        }
    }

    public Double getPriceByWareId(Integer id) {
        try {
            Ware ware = this.getWareById(id);

            return ware.getPrice();
        } catch (Throwable t) {
            return 0.0;
        }
    }

    public Boolean shipAmountByWareId(Integer id, Integer amount) {
        try {
            Ware ware = this.getWareById(id);

            Integer available = ware.getQuantity();

            if (available < amount) {
                return false;
            }

            ware.setQuantity(available - amount);

            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public String getWaresWhereQuantityLessThan(Integer quantity) {
        ArrayList<String> wares = new ArrayList<>();

        for (Ware ware: this.wares) {
            if (ware.getQuantity() < quantity) {
                wares.add(String.join("_", new String[]{ware.getName(), ware.getPrice().toString()}));
            }
        }

        return String.join(", ", wares.toArray(new String[wares.size()]));
    }

    public Integer size() {
        return this.wares.size();
    }

    private Boolean contains(Ware ware) {
        return this.indexOf(ware) >= 0;
    }

    private Integer indexOf(Ware ware) {
        Integer i = 0;

        for (Ware w: this.wares) {
            if (w.getName().equalsIgnoreCase(ware.getName()) && w.getPrice().equals(ware.getPrice())) {
                return i;
            }

            i++;
        }

        return -1;
    }
}
