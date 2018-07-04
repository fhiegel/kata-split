package com.xspeedit.products;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Pack implements Iterable<Product> {

    public static final Pack EMPTY = new Pack(Collections.emptyList());
    private static final long LIMIT = 10;

    private final Collection<Product> products;

    private Pack(Collection<Product> products) {
        this.products = Collections.unmodifiableCollection(products);
    }

    public static Pack of(Product... products) {
        return of(Stream.of(products));
    }

    public static Pack of(Iterable<Product> products) {
        return of(StreamSupport.stream(products.spliterator(), false));
    }

    private static Pack of(Stream<Product> products) {
        return new Pack(products.collect(Collectors.toList()));
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

    // Object implementation methods

    @Override
    public String toString() {
        return "Pack{" +
                "products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack products1 = (Pack) o;
        return areCollectionEquals(products, products1.products);
    }

    private static boolean areCollectionEquals(Collection<?> first, Collection<?> second) {
        return first.containsAll(second) && second.containsAll(first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    public Pack add(Product product) {
        return of(potentialPack(product));
    }

    private Stream<Product> potentialPack(Product product) {
        return Stream.concat(products.stream(), Stream.of(product));
    }

    public boolean canContain(Product product) {
        return potentialPack(product)
                .mapToInt(Product::size)
                .sum() <= LIMIT;
    }
}
