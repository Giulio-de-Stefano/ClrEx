package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class World {
    public WebDriver driver;
    public HomePage homePage;

    public World() {
        driver = initChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    private ChromeDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/gg/chromedriver");
        return new ChromeDriver();
    }
}


