package com.xspeedit.products;

public class OptimizedProductsPackager implements ProductsPackager {
    @Override
    public PackagedProducts packageProducts(Products products) {
        return PackagedProducts.EMPTY;
    }
}
