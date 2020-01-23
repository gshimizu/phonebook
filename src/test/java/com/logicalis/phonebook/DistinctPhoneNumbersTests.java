package com.logicalis.phonebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class DistinctPhoneNumbersTests {

    @Test
    public void iteratorShouldReturnDistinctElements() {
        PhoneNumbers numbers = () ->
                Arrays.asList(
                        new PhoneNumber("019987654321"),
                        new PhoneNumber("011987654321"),
                        new PhoneNumber("011987654321"),
                        new PhoneNumber("19987654321")).iterator();

        assertThat(new DistinctPhoneNumbers(numbers))
                .doesNotHaveDuplicates()
                .hasSize(2);
    }
}
