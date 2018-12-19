package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;

import static cucumber.World.driver;

public class Common implements En {

    public Common(World world) {

        When("^I navigate to the home page$", () -> {
            driver.navigate().to(world.homePage.getUrl());
        });

        When("^I am on the savings calculator page$", () -> {
            driver.navigate().to(world.savingsCalculatorPage.getUrl());
        });
    }

}
