package com.greensqa;

import com.greensqa.database.DatabaseInitializer;
import com.greensqa.repository.IUserRepository;
import com.greensqa.repository.UserRepository;
import com.greensqa.service.CsvService;
import com.greensqa.service.DataGeneratorService;

public class Main {

    public static void main(String[] args) throws Exception {

        DatabaseInitializer.initialize();

        IUserRepository repository =
                new UserRepository();

        repository.deleteAll();

        DataGeneratorService service =
                new DataGeneratorService(repository);

        int quantity = args.length > 0
                ? Integer.parseInt(args[0])
                : 100;


        service.generateUsersParallel(quantity);

        CsvService csvService =
                new CsvService();

        csvService.exportToCsv();
    }
}