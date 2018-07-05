package com.xspeedit.products;

import java.util.Objects;

public class Product {
    private final int length;

    private Product(int length) {
        this.length = length;
    }

    public static Product fromLength(int length) {
        return new Product(length);
    }

    // Object implementation methods

    @Override
    public String toString() {
        return "Product{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return length == product.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    public int length() {
        return length;
    }
}
