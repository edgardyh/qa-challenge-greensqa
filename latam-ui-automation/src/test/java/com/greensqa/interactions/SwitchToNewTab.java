package com.greensqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.ArrayList;

import static net.serenitybdd.core.Serenity.getDriver;

public class SwitchToNewTab implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        var tabs = new ArrayList<>(
                getDriver().getWindowHandles()
        );

        getDriver().switchTo().window(
                tabs.get(tabs.size() - 1)
        );
    }

    public static SwitchToNewTab now() {
        return new SwitchToNewTab();
    }
}