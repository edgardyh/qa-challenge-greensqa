package com.greensqa.tasks;

import com.greensqa.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenLatam implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url(HomePage.URL)
        );
    }

    public static OpenLatam website() {
        return instrumented(OpenLatam.class);
    }
}