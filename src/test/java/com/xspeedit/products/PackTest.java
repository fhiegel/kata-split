package com.xspeedit.products;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PackTest {

    @Test
    public void can_contain_product_which_fits_in_pack() {
        Pack pack = Pack.of(Product.fromLength(4));

        assertThat(pack.canContain(Product.fromLength(4))).isTrue();
    }

    @Test
    public void cannot_contain_oversize_product() {
        Pack pack = Pack.of(Product.fromLength(6));

        assertThat(pack.canContain(Product.fromLength(6))).isFalse();
    }

    @Test
    public void can_contain_product_which_exactly_fits_in_pack() {
        Pack pack = Pack.of(Product.fromLength(6));

        assertThat(pack.canContain(Product.fromLength(4))).isTrue();
    }

}