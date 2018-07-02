package com.xspeedit;

import com.xspeedit.products.*;

public class XspeedItApp {
    private final ProductPackager productPackager;
    private final ProductsParser productsParser;
    private final PackagedProductsDisplayer displayer;

    public XspeedItApp(ProductPackager productPackager) {
        this(productPackager, new ProductsParser(), new PackagedProductsDisplayer());
    }

    XspeedItApp(ProductPackager productPackager, ProductsParser productsParser, PackagedProductsDisplayer displayer) {
        this.productPackager = productPackager;
        this.productsParser = productsParser;
        this.displayer = displayer;
    }

    public String packageProducts(String rawProducts) {
        Products products = productsParser.parseProducts(rawProducts);
        PackagedProducts packagedProducts = productPackager.packageProducts(products);
        return displayer.display(packagedProducts);
    }
}
