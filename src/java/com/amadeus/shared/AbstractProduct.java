package java.com.amadeus.shared;

abstract public class AbstractProduct {
    private String code = "";
    private String title = "";
    private String description = "";
    private double price = 0.00;

    private int minCodeLenght = 5;

    public AbstractProduct(String code) {
        if(code.trim().length() < minCodeLenght) {
            this.code = code;
        } else {
            throw new IllegalArgumentException(String.format("Product code must contain at least %d parameters", minCodeLenght));
        }
    }

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
