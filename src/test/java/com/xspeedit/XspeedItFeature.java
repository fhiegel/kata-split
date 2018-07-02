package com.xspeedit;

import com.xspeedit.products.ProductPackager;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class XspeedItFeature {

    @Test
    public void should_package_items_in_legacy_way() {
        String products = "163841689525773";

        XspeedItApp app =  new XspeedItApp(new ProductPackager());
        String packagedProducts = app.packageProducts(products);

        assertThat(packagedProducts).isEqualTo("163/8/41/6/8/9/52/5/7/73");
    }

}
