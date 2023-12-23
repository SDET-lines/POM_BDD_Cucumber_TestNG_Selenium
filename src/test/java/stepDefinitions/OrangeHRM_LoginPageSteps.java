package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.OrangeHRM_DashboardPage;
import pages.OrangeHRM_LoginPage;

public class OrangeHRM_LoginPageSteps {

    private final OrangeHRM_LoginPage loginPage;
    private final OrangeHRM_DashboardPage dashboardPage;

    public OrangeHRM_LoginPageSteps (OrangeHRM_LoginPage loginPage,
                                     OrangeHRM_DashboardPage dashboardPage) {
        this.dashboardPage=dashboardPage;
        this.loginPage =loginPage;
    }

    @Given("user navigates to OrangeHRM Login Page")
    public void user_navigates_to_orange_hrm_login_page() {
       loginPage.navigateToHRM_LoginPage();
    }

    @When("user enters {string} username")
    public void setUsername(String string) {
       loginPage.setHRM_UsernameByFeatureFile(string);
    }

    @And("user enters {string} password")
    public void setPassword(String string) {
        loginPage.setHRM_PasswordByFeatureFile(string);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
       loginPage.clickLoginButton();
    }

    @Given("user logs in to OrangeHRM")
    public void user_logs_in_to_orange_hrm() {
        loginPage.logInToOrangeHRM();
    }

    @Then("user verifies message {string} under Username field")
    public void verifyMessageUnderUsernameField(String expectedMessageUnderUsernameField) {
       Assert.assertEquals(loginPage.getTextUnderUsernameField(), expectedMessageUnderUsernameField,
               "Text message verification under username field failed");
    }

    @Then("user verifies message {string} under Password field")
    public void verifyMessageUnderPasswordField(String expectedMessageUnderPasswordField) {
        Assert.assertEquals(loginPage.getTextUnderPasswordField(), expectedMessageUnderPasswordField,
                "Text message verification under password field failed");
    }

    @Then("user verifies {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(loginPage.getTextFromErrorMessage(), expectedErrorMessage,
                "Error message does not match");
    }

    @Then("user should be able to verify Dashboard active tab on OrangeHRM Homepage")
    public void user_should_be_able_to_verify_dashboard_active_tab_on_orange_hrm_homepage() {
        Assert.assertEquals(dashboardPage.getTextFromDashboardTab(), "Dashboard",
                "Dashboard tab verification failed");
    }
}
