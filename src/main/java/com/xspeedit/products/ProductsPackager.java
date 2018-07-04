package com.xspeedit.products;

import java.util.ArrayList;
import java.util.Collection;

public class ProductsPackager {
    public PackagedProducts packageProducts(Products products) {
        Collection<Pack> packs = new ArrayList<>();

        Pack pack = Pack.EMPTY;
        for (Product product : products) {
            if (pack.canContain(product)) {
                pack = pack.add(product);
            } else {
                packs.add(pack);
                pack = Pack.EMPTY;
                pack = pack.add(product);
            }
        }
        packs.add(pack);

        return PackagedProducts.of(packs);
    }
}
