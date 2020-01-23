package com.logicalis.phonebook;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class SortedPhoneNumbers implements PhoneNumbers {

    private final List<PhoneNumber> phoneNumbers;

    SortedPhoneNumbers(PhoneNumbers numbers,
                       Comparator<PhoneNumber> comparator) {
        Objects.requireNonNull(numbers, "Phone numbers must not be null");
        Objects.requireNonNull(comparator, "Phone number comparator must not be null");

        this.phoneNumbers =
                StreamSupport.stream(numbers.spliterator(), false)
                        .sorted(comparator)
                        .collect(Collectors.toList());
    }

    @Override
    public Iterator<PhoneNumber> iterator() {
        return phoneNumbers.iterator();
    }
}
