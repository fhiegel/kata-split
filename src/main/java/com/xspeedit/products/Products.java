package com.xspeedit.products;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Products {

    public static final Products EMPTY = new Products(Collections.emptyList());

    private final Collection<Product> products;

    private Products(Collection<Product> products) {
        this.products = Collections.unmodifiableCollection(products);
    }

    public static Products of(Product... products) {
        return of(Stream.of(products));
    }

    public static Products of(Stream<Product> products) {
        return new Products(products.collect(Collectors.toList()));
    }

    public Stream<Product> stream() {
        return products.stream();
    }

    public Iterable<Product> iterate() {
        return products;
    }

}

