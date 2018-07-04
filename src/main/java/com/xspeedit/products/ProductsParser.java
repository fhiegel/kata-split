package com.xspeedit.products;

import java.util.Arrays;
import java.util.function.Predicate;

public class ProductsParser {
    public Products parseProducts(String rawProduct) {
        return Products.of(Arrays.stream(rawProduct.split(""))
                .filter(notEmpty())
                .map(Integer::valueOf)
                .map(Product::fromSize));
    }

    private Predicate<String> notEmpty() {
        Predicate<String> empty = String::isEmpty;
        return empty.negate();
    }
}
