package com.greensqa.questions;

import com.greensqa.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DestinationValidationDisplayed
        implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return HomePage
                .DESTINATION_REQUIRED_MESSAGE
                .resolveFor(actor)
                .isVisible();
    }

    public static DestinationValidationDisplayed isVisible() {
        return new DestinationValidationDisplayed();
    }
}