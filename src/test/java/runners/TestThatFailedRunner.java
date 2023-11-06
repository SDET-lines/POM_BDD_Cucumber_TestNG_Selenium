package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/failed.txt"},
        glue = {"stepDefinitions"},

        plugin = {"html:target/cucumber-report/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestThatFailedRunner extends AbstractTestNGCucumberTests {
}
