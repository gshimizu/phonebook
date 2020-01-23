package com.logicalis.phonebook;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PhoneNumbersFromFileTests {

    @Test
    public void createWhenFilePathIsNullShouldThrowNullPointerException() {
        assertThatNullPointerException()
                .isThrownBy(() -> new PhoneNumbersFromFile(null));
    }

    @Test
    public void createWhenReadingFileFailsShouldThrowIllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PhoneNumbersFromFile(Paths.get("dev/null")));
    }

    @Test
    public void iteratorShouldReturnAllElementsReadFromFile() {
        Path testFile = Paths.get("src/test/resources/test-phone-numbers");

        assertThat(new PhoneNumbersFromFile(testFile))
                .hasSize(10);
    }
}
