package com.xspeedit.products;

public class OldProductsPackager implements ProductsPackager {

    @Override
    public PackagedProducts packageProducts(Products products) {

        PackagedProducts packagedProducts = PackagedProducts.EMPTY;

        Pack pack = Pack.EMPTY;
        for (Product product : products.iterate()) {
            if (!pack.canContain(product)) {
                packagedProducts = packagedProducts.add(pack);
                pack = Pack.EMPTY;
            }
            pack = pack.add(product);
        }
        packagedProducts = packagedProducts.add(pack);

        return packagedProducts;
    }

}
