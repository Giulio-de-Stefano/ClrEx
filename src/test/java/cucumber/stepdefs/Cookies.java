package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Cookies implements En {

    public Cookies(World world) {

        Then("^the cookies alert panel is displayed", () -> {
            assertTrue(world.homePage.cookieAlertPanel.isDisplayed());
        });

        Then("^the cookies alert panel is not displayed", () -> {
            assertFalse(world.homePage.cookieAlertPanel.isDisplayed());
        });

        When("^I click on the cookie dismissal button$", () -> {
            world.homePage.cookieAlertAcceptCookiesBtn.click();
        });

    }

}
