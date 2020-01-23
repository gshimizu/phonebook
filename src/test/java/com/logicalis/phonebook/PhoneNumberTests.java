package com.logicalis.phonebook;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PhoneNumberTests {

    @Test
    public void createWhenPhoneNumberValueIsNullShouldThrowNullPointerException() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> new PhoneNumber(null));
    }

    @Test
    public void createWhenPhoneNumberValueIsInvalidShouldThrowIllegalArgumentException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PhoneNumber("0019987654321"));
    }

    @Test
    public void toStringShouldBeImplemented() {
        Assertions.assertThat(new PhoneNumber("019987654321"))
                .hasToString("PhoneNumber{areaCode='AreaCode{value='19'}', number='987654321'}");
    }
}
