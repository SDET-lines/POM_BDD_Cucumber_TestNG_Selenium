package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlertPage;

public class AlertPageSteps {

    private final AlertPage alertPage;

    public AlertPageSteps(AlertPage alertPage) {
        this.alertPage = alertPage;
    }

    @Given("user navigates to Alerts Page")
    public void user_navigates_to_Alerts_Page() {
        alertPage.navigateToAlertPage();
    }

    @When("user clicks on {string} on Alerts Page")
    public void user_clicks_on_alert_on_Alerts_Page(String alertType) {
        alertPage.switchToTheCorrespondingAlertType(alertType);
    }

    @Then("user should be able to validate {string} alert on Alert Page")
    public void userShouldBeAbleToHandleAlertsOnAlertPage(String expectedAlertText) {
        alertPage.waitForAlertAndValidateText(expectedAlertText);
    }
}
