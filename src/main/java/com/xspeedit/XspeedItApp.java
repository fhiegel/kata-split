package com.xspeedit;

import com.xspeedit.products.*;

public class XspeedItApp {
    private final ProductsParser parser;
    private final ProductsPackager packager;
    private final PackagedProductsDisplayer displayer;

    public XspeedItApp(ProductsPackager packager) {
        this(new ProductsParser(), packager, new PackagedProductsDisplayer());
    }

    XspeedItApp(ProductsParser parser, ProductsPackager packager, PackagedProductsDisplayer displayer) {
        this.parser = parser;
        this.packager = packager;
        this.displayer = displayer;
    }

    public String packageProducts(String rawProducts) {
        Products products = parser.parseProducts(rawProducts);
        PackagedProducts packagedProducts = packager.packageProducts(products);
        return displayer.display(packagedProducts);
    }
}
