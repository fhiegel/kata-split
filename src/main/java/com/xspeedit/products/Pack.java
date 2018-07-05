package com.xspeedit.products;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pack {

    public static final Pack EMPTY = new Pack(Collections.emptyList());

    private static final long DEFAULT_PACK_TOTAL_LENGTH = 10;

    private final long packTotalLength;
    private final Collection<Product> products;

    private Pack(Collection<Product> products) {
        this(DEFAULT_PACK_TOTAL_LENGTH, products);
    }

    private Pack(long packTotalLength, Collection<Product> products) {
        this.packTotalLength = packTotalLength;
        this.products = Collections.unmodifiableCollection(products);
    }

    public static Pack of(Product... products) {
        return of(Stream.of(products));
    }

    private static Pack of(Stream<Product> products) {
        return new Pack(products.collect(Collectors.toList()));
    }

    public Pack add(Product product) {
        Collection<Product> nextProducts = new ArrayList<>(products);
        nextProducts.add(product);
        return new Pack(packTotalLength, nextProducts);
    }

    public boolean canContain(Product product) {
        return Stream.concat(stream(), Stream.of(product))
                .mapToInt(Product::length)
                .sum() <= packTotalLength;
    }

    public Stream<Product> stream() {
        return products.stream();
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

}
