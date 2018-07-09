package com.xspeedit.products;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class OptimizedProductsPackager implements ProductsPackager {
    @Override
    public PackagedProducts packageProducts(Products products) {
        PackagedProducts packagedProducts = PackagedProducts.EMPTY;

        List<Product> productList = products.stream()
                .sorted(comparingInt(Product::length).reversed())
                .collect(Collectors.toList());

        for (Product product : productList) {
            Pack mayBePack = packagedProducts.stream()
                    .filter(pack -> pack.canContain(product))
                    .findFirst()
                    .orElse(Pack.EMPTY);
            packagedProducts = packagedProducts.replaceWith(mayBePack, mayBePack.add(product));
        }

        return packagedProducts;
    }
}
