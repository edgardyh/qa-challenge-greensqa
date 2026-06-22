package com.greensqa.questions;

import com.greensqa.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FlightResultsVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return HomePage.FLIGHT_RESULTS_TITLE
                .resolveFor(actor)
                .isVisible();
    }

    public static FlightResultsVisible areDisplayed() {
        return new FlightResultsVisible();
    }
}