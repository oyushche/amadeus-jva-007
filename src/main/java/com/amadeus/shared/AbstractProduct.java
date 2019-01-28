package com.amadeus.shared;

abstract public class AbstractProduct {
    protected String code;
    protected String title = "";
    protected String description = "";
    protected double price = 0.00;

    public String getCode() {
        return code;
    }

    public AbstractProduct setCode(String code) {
        this.code = code;

        return this;
    }

    public String getTitle() {
        return title;
    }

    public AbstractProduct setTitle(String title) {
        this.title = title;

        return this;
    }

    public String getDescription() {
        return description;
    }

    public AbstractProduct setDescription(String description) {
        this.description = description;

        return this;
    }

    public double getPrice() {
        return price;
    }

    public AbstractProduct setPrice(double price) {
        this.price = price;

        return this;
    }
}
