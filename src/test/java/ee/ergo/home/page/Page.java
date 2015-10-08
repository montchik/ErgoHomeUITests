package ee.ergo.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Page {

    private static WebDriver driver;

    protected static WebDriver getDriver() {
        initDriver();

        return driver;
    }

    // initiates driver
    private static void initDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();

            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    if (driver != null) {
                        driver.quit();
                    }
                }
            });
        }
    }

    // Contains all movements that go to a generic page. Going to specific
    // material etc. should be handled by the test.
    public static void goToLandingPage() {
        getDriver().get("http://oxygen.netgroupdigital.com/");
    }

}
