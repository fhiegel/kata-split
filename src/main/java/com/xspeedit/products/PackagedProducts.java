package com.xspeedit.products;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PackagedProducts {

    public static final PackagedProducts EMPTY = new PackagedProducts(Collections.emptyList());

    private final Collection<Pack> packs;

    private PackagedProducts(Collection<Pack> packs) {
        this.packs = Collections.unmodifiableCollection(packs);
    }

    public static PackagedProducts of(Pack... packs) {
        return of(Stream.of(packs));
    }

    private static PackagedProducts of(Stream<Pack> packs) {
        return new PackagedProducts(packs.collect(Collectors.toList()));
    }

    public Stream<Pack> stream() {
        return packs.stream();
    }

    public Optional<Pack> findFirst(Predicate<Pack> predicate) {
        return stream().filter(predicate)
                .findFirst();
    }

    public PackagedProducts add(Pack pack) {
        Collection<Pack> nextPacks = new ArrayList<>(packs);
        nextPacks.add(pack);
        return new PackagedProducts(nextPacks);
    }

    public PackagedProducts replaceWith(Pack pack, Pack newPack) {
        List<Pack> nextPacks = new ArrayList<>(packs);
        int indexOfRemoved = nextPacks.indexOf(pack);
        nextPacks.remove(pack);
        nextPacks.add(indexOfRemoved, newPack);
        return new PackagedProducts(nextPacks);
    }

    // Object implementation methods

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
