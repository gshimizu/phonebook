package com.logicalis.phonebook;

import java.util.Comparator;

enum KnownAreaCodes implements Comparator<AreaCode> {

    FROM_SAO_PAULO {

        private final AreaCode saoPaulo = new AreaCode("11");

        @Override
        public int compare(AreaCode areaCode1, AreaCode areaCode2) {
            return saoPaulo.equals(areaCode1) && saoPaulo.equals(areaCode2) ? 0
                : saoPaulo.equals(areaCode1) ? -1
                : saoPaulo.equals(areaCode2) ? 1 : 0;
        }
    },

    FROM_CAMPINAS {

        private final AreaCode campinas = new AreaCode("19");

        @Override
        public int compare(AreaCode areaCode1, AreaCode areaCode2) {
            return campinas.equals(areaCode1) && campinas.equals(areaCode2) ? 0
                : campinas.equals(areaCode1) ? -1
                : campinas.equals(areaCode2) ? 1 : 0;
        }
    }
}
