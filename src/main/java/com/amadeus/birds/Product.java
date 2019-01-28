package com.amadeus.birds;

import com.amadeus.shared.AbstractProduct;

import java.util.Objects;

public class Product extends AbstractProduct {
    private Currency currency;

    public Product(ProductBuilder ProductBuilder) {
        this.code = ProductBuilder.code;
        this.title = ProductBuilder.title;
        this.description = ProductBuilder.description;
        this.price = ProductBuilder.price;
        this.currency = ProductBuilder.currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Product setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

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

    public static final class ProductBuilder {
        private String code;
        private String title = "";
        private String description = "";
        private double price = 0.00;
        private Currency currency;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public static ProductBuilder anProduct(Product product) {
            return aProduct()
                .withCode(product.getCode())
                .withTitle(product.getTitle())
                .withdDscription(product.getDescription())
                .withdPrice(product.getPrice())
                .withdCurrency(product.getCurrency())
            ;
        }

        public ProductBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public ProductBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder withdDscription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder withdPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder withdCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public AbstractProduct build() {
            return new Product(this);
        }
    }
}
