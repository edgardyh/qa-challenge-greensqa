package com.greensqa.questions;

import com.greensqa.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NoMatchDestinationDisplayed
        implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return HomePage.NO_MATCH_DESTINATION
                .resolveFor(actor)
                .isVisible();
    }

    public static NoMatchDestinationDisplayed isVisible() {
        return new NoMatchDestinationDisplayed();
    }
}