package com.xspeedit;

import com.xspeedit.products.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class XspeedItAppTest {

    private static final String RAW_PRODUCTS = "";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ProductsParser parser;
    @Mock
    private ProductsPackager packager;
    @Mock
    private PackagedProductsDisplayer displayer;

    @InjectMocks
    private XspeedItApp app;

    @Test
    public void should_parse_incoming_products_when_package_them() {

        app.packageProducts(RAW_PRODUCTS);

        verify(parser).parseProducts(eq(RAW_PRODUCTS));
    }

    @Test
    public void should_package_given_products() {
        Products products = Products.EMPTY;
        given(parser.parseProducts(eq(RAW_PRODUCTS))).willReturn(products);

        app.packageProducts(RAW_PRODUCTS);

        verify(packager).packageProducts(eq(products));
    }

    @Test
    public void should_display_packaged_products() {
        Products products = Products.EMPTY;
        given(parser.parseProducts(eq(RAW_PRODUCTS))).willReturn(products);
        PackagedProducts packagedProducts = PackagedProducts.EMPTY;
        given(packager.packageProducts(eq(products))).willReturn(packagedProducts);

        app.packageProducts(RAW_PRODUCTS);

        verify(displayer).display(eq(packagedProducts));
    }
}