package java.com.amadeus.birds;

import java.com.amadeus.shared.AbstractProduct;
import java.util.Objects;

public class Product extends AbstractProduct {
    private Currency currency;

    public Product(String code) {
        super(code);
    }

    public Currency getCurrency() {
        return currency;
    }

    public Product setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    // https://dzone.com/articles/things-to-keep-in-mind-while-using-custom-classes

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractProduct that = (AbstractProduct) o;
        return Objects.equals(this.getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCode());
    }

    @Override
    public String toString() {
        return "Product{" +
            "code='" + this.getCode() + '\'' +
            ", title='" + this.getTitle() + '\'' +
            ", description='" + this.getDescription() + '\'' +
            ", price=" + this.getPrice() +
            ", currency=" + this.getCurrency() +
        '}';
    }
}
