package com.xspeedit.products;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsPackagerTest {

    private static final Product PRODUCT_OF_SIZE_ONE = aProduct(1);
    private static final Product PRODUCT_OF_SIZE_THREE = aProduct(3);
    private static final Product PRODUCT_OF_SIZE_FIVE = aProduct(5);

    private ProductsPackager productsPackager = new ProductsPackager();

    @Test
    public void should_package_a_single_product() {
        Products products = Products.of(PRODUCT_OF_SIZE_ONE);

        PackagedProducts packagedProducts = productsPackager.packageProducts(products);

        assertThat(packagedProducts.stream()).contains(Pack.of(PRODUCT_OF_SIZE_ONE));
    }

    @Test
    public void should_package_multiple_products() {
        Products products = Products.of(PRODUCT_OF_SIZE_ONE, PRODUCT_OF_SIZE_ONE, PRODUCT_OF_SIZE_THREE);

        PackagedProducts packagedProducts = productsPackager.packageProducts(products);

        assertThat(packagedProducts.stream()).contains(Pack.of(PRODUCT_OF_SIZE_ONE, PRODUCT_OF_SIZE_ONE, PRODUCT_OF_SIZE_THREE));
    }

    @Test
    public void should_package_multiple_product_in_packs_of_ten() {
        Products products = Products.of(PRODUCT_OF_SIZE_FIVE, PRODUCT_OF_SIZE_FIVE, PRODUCT_OF_SIZE_FIVE);

        PackagedProducts packagedProducts = productsPackager.packageProducts(products);

        assertThat(packagedProducts.stream()).containsExactly(
                Pack.of(PRODUCT_OF_SIZE_FIVE, PRODUCT_OF_SIZE_FIVE),
                Pack.of(PRODUCT_OF_SIZE_FIVE));
    }

    private static Product aProduct(int productSize) {
        return Product.fromLength(productSize);
    }
}