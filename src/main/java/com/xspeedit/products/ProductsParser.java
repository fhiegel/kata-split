package com.xspeedit.products;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductsParser {
    public Products parseProducts(String rawProduct) {
        return new Products(Arrays.stream(rawProduct.split(""))
                .filter(notEmpty())
                .map(Integer::valueOf)
                .map(Product::fromSize)
                .collect(Collectors.toList()));
    }

    private Predicate<String> notEmpty() {
        Predicate<String> empty = String::isEmpty;
        return empty.negate();
    }
}
