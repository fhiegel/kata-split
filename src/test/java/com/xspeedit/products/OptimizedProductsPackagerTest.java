package com.xspeedit.products;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OptimizedProductsPackagerTest {

    private static final Product PRODUCT_OF_LENGTH_ONE = Product.fromLength(1);

    private ProductsPackager productsPackager = new OptimizedProductsPackager();

    @Test
    public void should_package_a_single_product() {
        Products products = Products.of(PRODUCT_OF_LENGTH_ONE);

        PackagedProducts packagedProducts = productsPackager.packageProducts(products);

        assertThat(packagedProducts.stream()).contains(Pack.of(PRODUCT_OF_LENGTH_ONE));
    }

    @Test
    public void should_package_a_multiple_products() {
        Products products = Products.of(PRODUCT_OF_LENGTH_ONE, PRODUCT_OF_LENGTH_ONE);

        PackagedProducts packagedProducts = productsPackager.packageProducts(products);

        assertThat(packagedProducts.stream()).contains(Pack.of(PRODUCT_OF_LENGTH_ONE, PRODUCT_OF_LENGTH_ONE));
    }

}