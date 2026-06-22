package com.greensqa.utils;

import com.greensqa.model.FlightData;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CsvReader {

    private static final String CSV_PATH =
            "src/test/resources/users.csv";

    public static FlightData getRandomFlight() {

        try {

            CSVReader reader =
                    new CSVReader(
                            new FileReader(CSV_PATH)
                    );

            List<String[]> rows = reader.readAll();

            rows.remove(0);

            List<FlightData> flights =
                    new ArrayList<>();

            for (String[] row : rows) {

                flights.add(
                        new FlightData(
                                row[8],
                                row[9]
                        )
                );
            }

            Random random = new Random();

            return flights.get(
                    random.nextInt(
                            flights.size()
                    )
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error reading CSV", e
            );
        }
    }
}