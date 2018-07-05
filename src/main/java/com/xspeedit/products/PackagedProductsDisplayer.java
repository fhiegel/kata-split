package com.xspeedit.products;

import java.util.stream.Collectors;

public class PackagedProductsDisplayer {
    public String display(PackagedProducts packagedProducts) {
        return packagedProducts.stream()
                .map(this::display)
                .collect(Collectors.joining("/"));
    }

    String display(Pack pack) {
        StringBuilder builder = new StringBuilder();
        for (Product product : pack) {
            builder.append(product.size());
        }
        return builder.toString();
    }

}
