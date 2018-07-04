package com.xspeedit.products;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PackagedProducts implements Iterable<Pack> {

    public static final PackagedProducts EMPTY = new PackagedProducts(Collections.emptyList());

    private final Collection<Pack> packs;

    private PackagedProducts(Collection<Pack> packs) {
        this.packs = Collections.unmodifiableCollection(packs);
    }

    public static PackagedProducts of(Pack... packs) {
        return of(Stream.of(packs));
    }

    public static PackagedProducts of(Iterable<Pack> packs) {
        return of(StreamSupport.stream(packs.spliterator(), false));
    }

    private static PackagedProducts of(Stream<Pack> packs) {
        return new PackagedProducts(packs.collect(Collectors.toList()));
    }

    @Override
    public Iterator<Pack> iterator() {
        return packs.iterator();
    }

    @Override
    public void forEach(Consumer<? super Pack> action) {
        packs.forEach(action);
    }

    @Override
    public Spliterator<Pack> spliterator() {
        return packs.spliterator();
    }

    @Override
    public String toString() {
        return "PackagedProducts{" +
                "packs=" + packs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagedProducts other = (PackagedProducts) o;
        return areCollectionEquals(packs, other.packs);
    }

    private static boolean areCollectionEquals(Collection<?> first, Collection<?> second) {
        return first.containsAll(second) && second.containsAll(first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packs);
    }

}
