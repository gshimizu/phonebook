package com.logicalis.phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PhoneNumbersFromFile implements PhoneNumbers {

    private final List<PhoneNumber> phoneNumbers;

    PhoneNumbersFromFile(Path filePath) {
        Objects.requireNonNull(filePath, "File path must not be null");

        try (Stream<String> lines = Files.lines(filePath)) {
            this.phoneNumbers =
                    lines.map(PhoneNumber::new)
                            .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not read the file " + filePath, e);
        }
    }

    @Override
    public Iterator<PhoneNumber> iterator() {
        return phoneNumbers.iterator();
    }
}
