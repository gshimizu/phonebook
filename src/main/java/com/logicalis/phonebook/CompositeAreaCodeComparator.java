package com.logicalis.phonebook;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

class CompositeAreaCodeComparator implements Comparator<AreaCode> {

    private final Comparator<AreaCode> comparator;

    CompositeAreaCodeComparator(Collection<Comparator<AreaCode>> comparators) {
        Objects.requireNonNull(comparators, "Comparator collection must not be null");

        this.comparator =
                comparators.stream()
                        .reduce(Comparator::thenComparing)
                        .orElseThrow(() -> new IllegalArgumentException("Comparators are not valid"));
    }

    @Override
    public int compare(AreaCode areaCode1, AreaCode areaCode2) {
        return comparator.compare(areaCode1, areaCode2);
    }
}
