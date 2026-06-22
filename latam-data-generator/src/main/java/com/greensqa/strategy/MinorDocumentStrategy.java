package com.greensqa.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class MinorDocumentStrategy
        implements DocumentStrategy {

    @Override
    public String generateDocument() {

        return "11000000" +
                ThreadLocalRandom.current()
                        .nextInt(1000,9999);
    }
}