package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;

public class Common implements En {

    public Common(World world) {

        When("^I navigate to the home page$", () -> {
            world.driver.navigate().to(world.homePage.getUrl());
        });
    }

}
