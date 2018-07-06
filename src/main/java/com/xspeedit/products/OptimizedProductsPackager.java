package com.xspeedit.products;

import java.util.Optional;

public class OptimizedProductsPackager implements ProductsPackager {
    @Override
    public PackagedProducts packageProducts(Products products) {
        PackagedProducts packagedProducts = PackagedProducts.EMPTY;

        for (Product product : products.iterate()) {
            Optional<Pack> mayBePack = packagedProducts.stream()
                    .filter(pack -> pack.canContain(product))
                    .findFirst();
            if (mayBePack.isPresent()) {
                Pack pack = mayBePack.get();
                packagedProducts = packagedProducts.replaceWith(pack, pack.add(product));
            } else {
                packagedProducts = packagedProducts.add(Pack.EMPTY.add(product));
            }
        }

        return packagedProducts;
    }
}
