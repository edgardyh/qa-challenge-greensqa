package com.greensqa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.greensqa.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
        //tags = "@positive"
)
public class FlightSearchRunner {
}