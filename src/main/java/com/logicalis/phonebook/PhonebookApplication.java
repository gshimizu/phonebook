package com.logicalis.phonebook;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PhonebookApplication {

    public static void main(String[] args) {
        List<Comparator<AreaCode>> saoPauloThenCampinasThenOthers =
                Arrays.asList(
                        KnownAreaCodes.FROM_SAO_PAULO,
                        KnownAreaCodes.FROM_CAMPINAS,
                        Comparator.naturalOrder());

        CompositeAreaCodeComparator areaCodeComparator =
                new CompositeAreaCodeComparator(saoPauloThenCampinasThenOthers);

        PhoneNumber.AreaCodeThenNumberOrder areaCodeThenNumberOrder =
                new PhoneNumber.AreaCodeThenNumberOrder(areaCodeComparator);

        PhoneNumbers phoneNumbers =
                new PhoneNumbersFromFile(Paths.get("src/main/resources/data/phone-numbers"));

        PhoneNumbers distinctPhoneNumbers =
                new DistinctPhoneNumbers(phoneNumbers);

        PhoneNumbers sortedDistinctPhoneNumbers =
                new SortedPhoneNumbers(distinctPhoneNumbers, areaCodeThenNumberOrder);

        sortedDistinctPhoneNumbers.forEach(System.out::println);
    }
}
