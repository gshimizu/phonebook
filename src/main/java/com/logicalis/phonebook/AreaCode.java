package com.logicalis.phonebook;

import java.util.Objects;
import java.util.regex.Pattern;

final class AreaCode implements Comparable<AreaCode> {

    private static final Pattern validAreaCodePattern =
            Pattern.compile("^[1-9]{2}$");

    private final String value;

    AreaCode(String value) {
        Objects.requireNonNull(value, "Area code value must not be null");

        if (!validAreaCodePattern.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid area code value: " + value);
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaCode areaCode = (AreaCode) o;
        return Objects.equals(value, areaCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AreaCode{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(AreaCode other) {
        return this.value.compareTo(other.value);
    }
}
