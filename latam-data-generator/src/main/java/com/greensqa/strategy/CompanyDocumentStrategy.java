package com.greensqa.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class CompanyDocumentStrategy
        implements DocumentStrategy {

    @Override
    public String generateDocument() {

        return "9" +
                String.format(
                        "%09d",
                        ThreadLocalRandom.current()
                                .nextInt(1_000_000_000)
                );
    }
}