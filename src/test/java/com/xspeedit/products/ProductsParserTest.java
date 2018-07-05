package com.xspeedit.products;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsParserTest {

    private ProductsParser productsParser = new ProductsParser();

    @Test
    public void should_parse_single_product() {
        String rawProducts = "1";

        Products products = productsParser.parseProducts(rawProducts);

        assertThat(products.stream()).contains(Product.fromLength(1));
    }

    @Test
    public void should_parse_three_products() {
        String rawProducts = "123";

        Products products = productsParser.parseProducts(rawProducts);

        assertThat(products.stream()).containsExactly(Product.fromLength(1), Product.fromLength(2), Product.fromLength(3));
    }

    @Test
    public void should_be_empty_when_no_product_to_parse() {
        String rawProducts = "";

        Products products = productsParser.parseProducts(rawProducts);

        assertThat(products.stream()).isEmpty();
    }
}