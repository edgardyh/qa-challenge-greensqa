package com.greensqa.service;

import com.greensqa.factory.UserFactory;
import com.greensqa.model.User;
import com.greensqa.repository.IUserRepository;
import com.greensqa.strategy.*;

import net.datafaker.Faker;

import java.util.Locale;
import java.util.Set;
import java.util.concurrent.*;

public class DataGeneratorService {

    private final IUserRepository repository;

    private final Faker faker =
            new Faker(new Locale("es"));

    private final UserFactory factory =
            new UserFactory();

    private final Set<String> documents =
            ConcurrentHashMap.newKeySet();

    private final Set<String> fullNames =
            ConcurrentHashMap.newKeySet();

    public DataGeneratorService(
            IUserRepository repository) {

        this.repository = repository;
    }

    public void generateUsers(int quantity){

        for(int i = 0 ; i < quantity ; i++){

            User user = generateUser();

            repository.save(user);
        }
    }

    public User generateUser() {

        boolean company =
                ThreadLocalRandom.current()
                        .nextBoolean();

        User user =
                factory.createUser(company);

        populateBasicData(user, company);

        return user;
    }

    private void populateBasicData(
            User user,
            boolean company) {

        String name;
        String lastName;

        do {

            name = faker.name().firstName();

            lastName = company ?
                    "" :
                    faker.name().lastName();

        }
        while (
                !fullNames.add(
                        name + lastName
                )
        );

        int age;
        if (company) {
            age = 18;
        } else {
            age = ThreadLocalRandom.current()
                    .nextInt(10, 80);
        }

        String document =
                generateDocument(
                        company,
                        age
                );

        String country =
                faker.country().name();

        String city =
                faker.address().city();

        String language;

        if(country.equalsIgnoreCase("Colombia")){

            language = "Español";

        }else{

            do{

                language =
                        faker.nation().language();

            }while(language.toLowerCase()
                    .contains("span"));
        }

        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        user.setDocument(document);
        user.setCountry(country);
        user.setCity(city);
        user.setLanguage(language);
        user.setOrigen(randomCity());
        String destino;
        do {
            destino = randomCity();
        } while (destino.equals(user.getOrigen())); // Evitar mismo origen y destino
        user.setDestino(destino);
    }

    private static final String[] CIUDADES = {
            "Cartagena", "Pereira", "Medellín", "Bogotá", "Cali"
    };

    private String randomCity() {
        return CIUDADES[ThreadLocalRandom.current()
                .nextInt(CIUDADES.length)];
    }

    private String generateDocument(
            boolean company,
            int age) {

        DocumentStrategy strategy;

        if(company){

            strategy =
                    new CompanyDocumentStrategy();

        } else if(age < 18){

            strategy =
                    new MinorDocumentStrategy();

        } else {

            strategy =
                    new AdultDocumentStrategy();
        }

        String document;

        do {

            document =
                    strategy.generateDocument();

        } while (
                !documents.add(document)
        );

        return document;
    }

    public void generateUsersParallel(
            int quantity)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(10);

        for(int i = 0 ; i < quantity ; i++){

            executor.submit(() -> {
                User user = generateUser();
                repository.save(user);
            });
        }

        executor.shutdown();

        executor.awaitTermination(
                1,
                TimeUnit.MINUTES
        );
    }
}