package com.xspeedit.products;

import java.util.stream.Collectors;

public class PackagedProductsDisplayer {

    public String display(PackagedProducts packagedProducts) {
        return packagedProducts.stream()
                .map(this::displayPack)
                .collect(Collectors.joining("/"));
    }

    String displayPack(Pack pack) {
        return pack.stream()
                .map(Product::length)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
