package com.greensqa.tasks;

import com.greensqa.interactions.SwitchToNewTab;
import com.greensqa.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchFlight implements Task {

    private final String origin;
    private final String destination;

    public SearchFlight(
            String origin,
            String destination
    ) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("ORIGIN = " + origin);
        System.out.println("DESTINATION = " + destination);

        actor.attemptsTo(

                Enter.theValue(origin)
                        .into(HomePage.ORIGIN_INPUT),

                WaitUntil.the(
                        HomePage.CITY_OPTION(origin),
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Click.on(HomePage.CITY_OPTION(origin))
        );


        if (destination == null ||
                destination.trim().isEmpty()) {

            actor.attemptsTo(
                    Click.on(HomePage.SEARCH_BUTTON)
            );

            return;
        }

        actor.attemptsTo(

                Enter.theValue(destination)
                        .into(HomePage.DESTINATION_INPUT)
        );


        if (origin.equalsIgnoreCase(destination)) {

            actor.attemptsTo(

                    WaitUntil.the(
                            HomePage.NO_MATCH_DESTINATION,
                            isVisible()
                    ).forNoMoreThan(10).seconds()
            );

            return;
        }

        actor.attemptsTo(

                WaitUntil.the(
                        HomePage.CITY_OPTION(destination),
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Click.on(HomePage.CITY_OPTION(destination)),

                Click.on(HomePage.DEPARTURE_BUTTON),

                Click.on(HomePage.DEPARTURE_DATE),

                Click.on(HomePage.RETURN_BUTTON),

                Click.on(HomePage.RETURN_DATE),

                Click.on(HomePage.SEARCH_BUTTON),

                SwitchToNewTab.now(),

                WaitUntil.the(
                        HomePage.FLIGHT_RESULTS_TITLE,
                        isVisible()
                ).forNoMoreThan(30).seconds()
        );
    }

    public static SearchFlight betweenCities(
            String origin,
            String destination
    ) {
        return instrumented(
                SearchFlight.class,
                origin,
                destination
        );
    }
}