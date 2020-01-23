package com.logicalis.phonebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class SortedPhoneNumbersTests {

    @Test
    public void iteratorShouldReturnSortedElements() {
        PhoneNumbers numbers = () ->
                Arrays.asList(
                        new PhoneNumber("019987654321"),
                        new PhoneNumber("011987654321"),
                        new PhoneNumber("19976543210"),
                        new PhoneNumber("12987654321")).iterator();

        PhoneNumber.AreaCodeThenNumberOrder areaCodeThenNumberOrder =
                new PhoneNumber.AreaCodeThenNumberOrder(Comparator.naturalOrder());

        assertThat(new SortedPhoneNumbers(numbers, areaCodeThenNumberOrder))
                .containsExactly(
                        new PhoneNumber("011987654321"),
                        new PhoneNumber("12987654321"),
                        new PhoneNumber("19976543210"),
                        new PhoneNumber("019987654321"));
    }
}
