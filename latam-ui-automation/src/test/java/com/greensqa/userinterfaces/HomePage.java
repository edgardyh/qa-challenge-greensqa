package com.greensqa.userinterfaces;

import com.greensqa.utils.CityMapper;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final String URL =
            "https://www.latamairlines.com";

    public static final Target ORIGIN_INPUT =
            Target.the("origin input")
                    .located(By.xpath("//*[@id='fsb-origin--text-field']"));

    public static Target CITY_OPTION(String city) {

        String code = CityMapper.codeOf(city);

        return Target.the("city option " + city)
                .located(By.xpath(
                        "//*[contains(@id,'" + code + "_co_airport')]"
                ));
    }

    public static final Target DESTINATION_INPUT =
            Target.the("destination input")
                    .located(By.xpath("//*[@id='fsb-destination--text-field']"));


    public static final Target DEPARTURE_BUTTON =
            Target.the("departure button")
                    .located(By.xpath("//*[@id='fsb-return']"));

    public static final Target DEPARTURE_DATE =
            Target.the("departure date")
                    .located(By.xpath("//*[@id='date-2026-07-15']/div"));

    public static final Target RETURN_BUTTON =
            Target.the("return button")
                    .located(By.xpath("//*[@id='fsb-return--text-field']"));

    public static final Target RETURN_DATE =
            Target.the("return date")
                    .located(By.xpath("//*[@id='date-2026-07-30']/div"));

    public static final Target SEARCH_BUTTON =
            Target.the("search flights")
                    .located(By.xpath("//*[@id='fsb-search-flights']"));

    public static final Target FLIGHT_RESULTS_TITLE =
            Target.the("flight results title")
                    .located(By.xpath(
                            "//*[@id='titleSelectFlightDesktop']/span[1]"
                    ));

    public static final Target NO_MATCH_DESTINATION =
            Target.the("destination without matches")
                    .located(By.xpath(
                            "//*[@id='fsb-destination--autocomplete__no-match']/span"
                    ));

    public static final Target DESTINATION_REQUIRED_MESSAGE =
            Target.the("destination required message")
                    .located(By.xpath(
                            "//*[@id='fsb-destination--text-field__helper-text']"
                    ));

}