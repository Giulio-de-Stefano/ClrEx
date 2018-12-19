package cucumber;

import cucumber.World;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void before() {
        World.initChromeDriver();
    }

    @After
    public void after() {
        World.driver.quit();
    }
}
