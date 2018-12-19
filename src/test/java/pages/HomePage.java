package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageAB {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cs-cookie")
    public WebElement cookieAlertPanel;
}