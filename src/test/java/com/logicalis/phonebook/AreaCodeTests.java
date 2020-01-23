package com.logicalis.phonebook;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AreaCodeTests {

    @Test
    public void createWhenAreaCodeValueIsNullShouldThrowNullPointerException() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> new AreaCode(null));
    }

    @Test
    public void createWhenAreaCodeValueIsInvalidShouldThrowIllegalArgumentException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new AreaCode("00"));
    }

    @Test
    public void toStringShouldBeImplemented() {
        Assertions.assertThat(new AreaCode("19"))
                .hasToString("AreaCode{value='19'}");
    }

    @Test
    public void compareToWhenFirstAreaCodeValueIsLessThanSecondAreaCodeValueShouldReturnNegative() {
        AreaCode firstAreaCode = new AreaCode("11");
        AreaCode secondAreaCode = new AreaCode("19");

        Assertions.assertThat(firstAreaCode.compareTo(secondAreaCode))
                .isNegative();
    }

    @Test
    public void compareToWhenFirstAreaCodeValueIsGreaterThanSecondAreaCodeValueShouldReturnPositive() {
        AreaCode firstAreaCode = new AreaCode("19");
        AreaCode secondAreaCode = new AreaCode("11");

        Assertions.assertThat(firstAreaCode.compareTo(secondAreaCode))
                .isPositive();
    }

    @Test
    public void compareToWhenFirstAreaCodeValueIsEqualToSecondAreaCodeValueShouldReturnZero() {
        AreaCode firstAreaCode = new AreaCode("19");
        AreaCode secondAreaCode = new AreaCode("19");

        Assertions.assertThat(firstAreaCode.compareTo(secondAreaCode))
                .isZero();
    }
}
