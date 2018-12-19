package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;
import org.openqa.selenium.Cookie;

import static cucumber.World.driver;
import static org.testng.Assert.*;

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

        Then("^the browser contains the cookie alert dismissal cookie$", () -> {
            String expCookieName = "CS_ACCEPT_COOKIES";
            String expCookieValue = "true";

            Cookie alertDismissedCookie = driver.manage().getCookieNamed(expCookieName);
            assertNotNull(alertDismissedCookie);
            assertEquals(alertDismissedCookie.getValue(), expCookieValue);
        });
    }

}
