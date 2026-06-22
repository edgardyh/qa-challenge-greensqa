package com.greensqa.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class AdultDocumentStrategy
        implements DocumentStrategy {

    @Override
    public String generateDocument() {

        return String.valueOf(
                ThreadLocalRandom.current()
                        .nextLong(
                                100000000L,
                                99999999999L
                        )
        );
    }
}