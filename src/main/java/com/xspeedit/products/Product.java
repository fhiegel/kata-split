package com.xspeedit.products;

import java.util.Objects;

public class Product {
    private final int size;

    private Product(int size) {
        this.size = size;
    }

    public static Product fromSize(int size) {
        return new Product(size);
    }

    // Object implementation methods

    @Override
    public String toString() {
        return "Product{" +
                "size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return size == product.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public int size() {
        return size;
    }
}
