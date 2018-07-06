package com.xspeedit.products;

public class OptimizedProductsPackager implements ProductsPackager {
    @Override
    public PackagedProducts packageProducts(Products products) {
        return products.stream()
                .map(Pack::of)
                .map(PackagedProducts::of)
                .findFirst()
                .orElse(PackagedProducts.EMPTY);
    }
}
