package pages;

import org.openqa.selenium.WebDriver;

public class PageAB {
    WebDriver driver;
    String url = "https://www.clearscore.com";

    public PageAB(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }
}