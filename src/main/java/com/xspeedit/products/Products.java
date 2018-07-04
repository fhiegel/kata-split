package com.xspeedit.products;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Products implements Iterable<Product>{

    public static final Products EMPTY = new Products(Collections.emptyList());

    private final Collection<Product> products;

    private Products(Collection<Product> products) {
        this.products = Collections.unmodifiableCollection(products);
    }

    public static Products of(Product... products) {
        return of(Stream.of(products));
    }

    public static Products of(Iterable<Product> products) {
        return of(StreamSupport.stream(products.spliterator(), false));
    }

    public static Products of(Stream<Product> products) {
        return new Products(products.collect(Collectors.toList()));
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    @Override
    public void forEach(Consumer<? super Product> action) {
        products.forEach(action);
    }

    @Override
    public Spliterator<Product> spliterator() {
        return products.spliterator();
    }
}
