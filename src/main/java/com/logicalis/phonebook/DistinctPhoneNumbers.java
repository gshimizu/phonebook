package com.logicalis.phonebook;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class DistinctPhoneNumbers implements PhoneNumbers {

    private final Set<PhoneNumber> phoneNumbers;

    DistinctPhoneNumbers(PhoneNumbers numbers) {
        Objects.requireNonNull(numbers, "Phone numbers must not be null");

        this.phoneNumbers =
                StreamSupport.stream(numbers.spliterator(), false)
                        .collect(Collectors.toSet());
    }

    @Override
    public Iterator<PhoneNumber> iterator() {
        return phoneNumbers.iterator();
    }
}
