package com.xspeedit.products;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PackagedProductsDisplayerTest {

    private PackagedProductsDisplayer displayer = new PackagedProductsDisplayer();

    @Test
    public void should_display_a_single_packaged_product() {
        PackagedProducts packagedProducts = PackagedProducts.of(Pack.of(Product.fromLength(1)));

        String display = displayer.display(packagedProducts);

        assertThat(display).isEqualTo("1");
    }

    @Test
    public void should_display_a_multiple_products_in_single_pack() {
        PackagedProducts packagedProducts = PackagedProducts.of(Pack.of(Product.fromLength(1), Product.fromLength(2)));

        String display = displayer.display(packagedProducts);

        assertThat(display).isEqualTo("12");
    }

    @Test
    public void should_display_a_multiple_products_in_multiple_packs() {
        PackagedProducts packagedProducts = PackagedProducts.of(Pack.of(Product.fromLength(1)),Pack.of(Product.fromLength(1)));

        String display = displayer.display(packagedProducts);

        assertThat(display).isEqualTo("1/1");
    }
}