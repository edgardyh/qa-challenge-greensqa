package com.greensqa.stepdefinitions;

import com.greensqa.questions.*;
import com.greensqa.tasks.OpenLatam;
import com.greensqa.tasks.SearchFlight;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import com.greensqa.model.FlightData;
import com.greensqa.utils.CsvReader;

import static junit.framework.TestCase.assertTrue;

public class FlightSearchStepDefinition {

    private Actor user;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();

        OnStage.setTheStage(
                new OnlineCast()
        );

        user = OnStage.theActorCalled(
                "Tester"
        );
    }

    @Given("the user opens LATAM website")
    public void theUserOpensLatamWebsite() {

        user.attemptsTo(
                OpenLatam.website()
        );
    }

    @When("the user searches a flight using generated data")
    public void theUserSearchesAFlightUsingGeneratedData() {
        FlightData data =
                CsvReader.getRandomFlight();

        System.out.println(
                "ORIGIN CSV = "
                        + data.getOrigen()
        );

        System.out.println(
                "DESTINATION CSV = "
                        + data.getDestino()
        );

        user.attemptsTo(
                SearchFlight.betweenCities(
                        data.getOrigen(),
                        data.getDestino()
                )
        );
    }

    @When("the user searches a flight from {string} to {string}")
    public void theUserSearchesAFlightFromTo(
            String origin,
            String destination
    ) {

        user.attemptsTo(
                SearchFlight.betweenCities(
                        origin,
                        destination
                )
        );
    }


    @Then("available flights should be displayed")
    public void availableFlightsShouldBeDisplayed() {
        assertTrue(
                FlightResultsVisible
                        .areDisplayed()
                        .answeredBy(user)
        );
    }

    @Then("destination should not have available options")
    public void destinationShouldNotHaveAvailableOptions() {
        assertTrue(
                NoMatchDestinationDisplayed
                        .isVisible()
                        .answeredBy(user)
        );
    }

    @Then("destination validation should be displayed")
    public void destinationValidationShouldBeDisplayed() {
        assertTrue(
                DestinationValidationDisplayed
                        .isVisible()
                        .answeredBy(user)
        );
    }


}