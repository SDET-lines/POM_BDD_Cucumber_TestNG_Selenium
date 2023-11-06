package stepDefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static utilities.DriverManager.cleanupDriver;
import static utilities.DriverManager.getDriver;

public class CommonHooks {

    @Before
    public void setup() {
        getDriver();
    }

    @AfterStep
    public void captureScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "The screenshot of the failed step");
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}








