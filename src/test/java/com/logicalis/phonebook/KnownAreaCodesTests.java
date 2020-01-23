package com.logicalis.phonebook;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class KnownAreaCodesTests {

    @Test
    public void compareFromSaoPauloWhenComparingFirstFromSaoPauloThenFromOtherShouldReturnNegative() {
        AreaCode areaCodeFromSP = new AreaCode("11");
        AreaCode areaCodeFromCampinas = new AreaCode("19");

        Assertions.assertThat(
                KnownAreaCodes.FROM_SAO_PAULO
                        .compare(areaCodeFromSP, areaCodeFromCampinas))
                .isNegative();
    }

    @Test
    public void compareFromSaoPauloWhenComparingFirstFromOtherThenFromSaoPauloShouldReturnPositive() {
        AreaCode areaCodeFromSP = new AreaCode("11");
        AreaCode areaCodeFromCampinas = new AreaCode("19");

        Assertions.assertThat(
                KnownAreaCodes.FROM_SAO_PAULO
                        .compare(areaCodeFromCampinas, areaCodeFromSP))
                .isPositive();
    }

    @Test
    public void compareFromSaoPauloWhenComparingBothFromSaoPauloShouldReturnZero() {
        AreaCode areaCodeFromSP = new AreaCode("11");
        AreaCode areaCodeFromSPToo = new AreaCode("11");

        Assertions.assertThat(
                KnownAreaCodes.FROM_SAO_PAULO
                        .compare(areaCodeFromSP, areaCodeFromSPToo))
                .isZero();
    }

    @Test
    public void compareFromSaoPauloWhenComparingBothFromOtherShouldReturnZero() {
        AreaCode areaCodeFromCampinas = new AreaCode("19");
        AreaCode areaCodeFromBauru = new AreaCode("14");

        Assertions.assertThat(
                KnownAreaCodes.FROM_SAO_PAULO
                        .compare(areaCodeFromCampinas, areaCodeFromBauru))
                .isZero();
    }

    @Test
    public void compareFromCampinasWhenComparingFirstFromCampinasThenFromOtherShouldReturnNegative() {
        AreaCode areaCodeFromCampinas = new AreaCode("19");
        AreaCode areaCodeFromSP = new AreaCode("11");

        Assertions.assertThat(
                KnownAreaCodes.FROM_CAMPINAS
                        .compare(areaCodeFromCampinas, areaCodeFromSP))
                .isNegative();
    }

    @Test
    public void compareFromCampinasWhenComparingFirstFromOtherThenFromCampinasShouldReturnPositive() {
        AreaCode areaCodeFromCampinas = new AreaCode("19");
        AreaCode areaCodeFromSP = new AreaCode("11");

        Assertions.assertThat(
                KnownAreaCodes.FROM_CAMPINAS
                        .compare(areaCodeFromSP, areaCodeFromCampinas))
                .isPositive();
    }

    @Test
    public void compareFromCampinasWhenComparingBothFromCampinasShouldReturnZero() {
        AreaCode areaCodeFromCampinas = new AreaCode("19");
        AreaCode areaCodeFromCampinasToo = new AreaCode("19");

        Assertions.assertThat(
                KnownAreaCodes.FROM_CAMPINAS
                        .compare(areaCodeFromCampinas, areaCodeFromCampinasToo))
                .isZero();
    }

    @Test
    public void compareFromCampinasWhenComparingBothFromOtherShouldReturnZero() {
        AreaCode areaCodeFromSaoCarlos = new AreaCode("16");
        AreaCode areaCodeFromBauru = new AreaCode("14");

        Assertions.assertThat(
                KnownAreaCodes.FROM_CAMPINAS
                        .compare(areaCodeFromSaoCarlos, areaCodeFromBauru))
                .isZero();
    }
}
