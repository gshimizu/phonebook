package com.logicalis.phonebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CompositeAreaCodeComparatorTests {

    @Test
    public void compareShouldPreserveCollectionOrder() {

        List<Comparator<AreaCode>> comparators =
                Arrays.asList(KnownAreaCodes.FROM_CAMPINAS,
                        KnownAreaCodes.FROM_SAO_PAULO);

        CompositeAreaCodeComparator compositeAreaCodeComparator =
                new CompositeAreaCodeComparator(comparators);

        List<AreaCode> areaCodes =
                Arrays.asList(
                        new AreaCode("12"),
                        new AreaCode("19"),
                        new AreaCode("11"));

        areaCodes.sort(compositeAreaCodeComparator);

        Assertions.assertThat(areaCodes)
                .isSortedAccordingTo(
                        KnownAreaCodes.FROM_CAMPINAS
                                .thenComparing(KnownAreaCodes.FROM_SAO_PAULO));
    }
}
