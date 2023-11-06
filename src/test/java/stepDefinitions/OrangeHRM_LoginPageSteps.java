package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.OrangeHRM_LoginPage;

public class OrangeHRM_LoginPageSteps extends BasePage {

    private final OrangeHRM_LoginPage HRM_LoginPage;

    public OrangeHRM_LoginPageSteps (OrangeHRM_LoginPage HRM_LoginPage) {
        this.HRM_LoginPage=HRM_LoginPage;
    }

    @Given("user navigates to OrangeHRM Login Page")
    public void user_navigates_to_orange_hrm_login_page() {
       HRM_LoginPage.navigateToHRM_LoginPage();
    }

    @When("user enters {string} username")
    public void user_enters_username(String string) {
       HRM_LoginPage.setHRM_UsernameByFeatureFile(string);
    }

    @And("user enters {string} password")
    public void user_enters_password(String string) {
        HRM_LoginPage.setHRM_PasswordByFeatureFile(string);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
       HRM_LoginPage.clickLoginButton();
    }

    @Given("user logs in to OrangeHRM")
    public void user_logs_in_to_orange_hrm() {
        HRM_LoginPage.logInToOrangeHRM();
    }

    @Then("user validates message {string} under Username field")
    public void user_validates_message_under_username_field(String expectedMessageUnderUsernameField) {
       Assert.assertEquals(HRM_LoginPage.getTextUnderUsernameField(), expectedMessageUnderUsernameField,
               "Text message verification under username field failed");
    }

    @Then("user validates message {string} under Password field")
    public void user_validates_message_under_password_field(String expectedMessageUnderPasswordField) {
        Assert.assertEquals(HRM_LoginPage.getTextUnderPasswordField(), expectedMessageUnderPasswordField,
                "Text message verification under password field failed");
    }

    @Then("user validates {string} error message")
    public void userValidatesErrorMessage(String expectedErrorMessage) {

        Assert.assertEquals(HRM_LoginPage.getTextFromErrorMessage(), expectedErrorMessage,
                "Error message does not match");
    }
}
