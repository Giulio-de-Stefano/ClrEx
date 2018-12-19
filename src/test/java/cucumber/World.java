package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.SavingsCalculatorPage;

public class World {
    public static WebDriver driver;
    public HomePage homePage;
    public SavingsCalculatorPage savingsCalculatorPage;

    public World() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        savingsCalculatorPage = PageFactory.initElements(driver, SavingsCalculatorPage.class);
    }

    public static void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/gg/chromedriver");
        driver = new ChromeDriver();
    }
}


