package com.xspeedit.products;

import java.util.*;
import java.util.function.Consumer;

public class Products implements Iterable<Product>{

    public static final Products EMPTY = new Products(Collections.emptyList());

    private final Collection<Product> products;

    public Products(Collection<Product> products) {
        this.products = Collections.unmodifiableCollection(products);
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
