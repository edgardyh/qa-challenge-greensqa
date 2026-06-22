package com.greensqa.utils;

public class CityMapper {

    public static String codeOf(String city) {

        switch (city.toUpperCase()) {

            case "BOGOTÁ":
                return "bog";

            case "MEDELLIN":
            case "MEDELLÍN":
                return "mde";

            case "CALI":
                return "clo";

            case "CARTAGENA":
                return "ctg";

            case "PEREIRA":
                return "pei";

            default:
                throw new IllegalArgumentException(
                        "Ciudad no soportada: " + city
                );
        }
    }
}