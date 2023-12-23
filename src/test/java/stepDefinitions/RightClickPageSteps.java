package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.RightClickPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RightClickPageSteps {

    private final RightClickPage rightClickPage;

    public RightClickPageSteps(RightClickPage rightClickPage) {
        this.rightClickPage=rightClickPage;
    }

    @Given("user navigates to the given website")
    public void user_navigates_to_the_given_website() {
        rightClickPage.navigateToRightClickPage();
    }

    @When("right clicks on the button")
    public void right_click_on_the_button()  {
        rightClickPage.rightClickOnTheButton();
    }

    @When("click the {string} from the list")
    public void click_the_option_from_the_list(String optionText) {
        rightClickPage.clickRightClickOption(optionText);
    }

    @Then("the alert should display the text {string}")
    public void the_alert_should_display_the_text (String expectedAlertText) {
        String actualAlertText = rightClickPage.switchToAlertAcceptAndGetText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Alert text verification failed");
    }
}
