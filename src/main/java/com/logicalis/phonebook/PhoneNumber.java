package com.logicalis.phonebook;

import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumber {

    private static final Pattern validPhoneNumberPattern =
            Pattern.compile("^0?(?<areaCode>[1-9]{2})(?<number>9\\d{8})$");

    private final AreaCode areaCode;

    private final String number;

    PhoneNumber(String value) {
        Objects.requireNonNull(value, "Phone number value must not be null");

        Matcher validPhoneNumberMatcher = validPhoneNumberPattern.matcher(value);

        if (validPhoneNumberMatcher.matches()) {
            this.areaCode = new AreaCode(validPhoneNumberMatcher.group("areaCode"));
            this.number = validPhoneNumberMatcher.group("number");
        } else {
            throw new IllegalArgumentException("Invalid phone number value: " + value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(areaCode, that.areaCode) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode='" + areaCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    static class AreaCodeThenNumberOrder implements Comparator<PhoneNumber> {

        private final Comparator<PhoneNumber> phoneNumberComparator;

        AreaCodeThenNumberOrder(Comparator<AreaCode> areaCodeComparator) {
            Objects.requireNonNull(areaCodeComparator, "");
            this.phoneNumberComparator =
                    Comparator.comparing((PhoneNumber phoneNumber) -> phoneNumber.areaCode, areaCodeComparator)
                            .thenComparing(phoneNumber -> phoneNumber.number);
        }

        @Override
        public int compare(PhoneNumber phoneNumber1, PhoneNumber phoneNumber2) {
            return this.phoneNumberComparator.compare(phoneNumber1, phoneNumber2);
        }
    }
}
