package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.RightClickPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class RightClickSteps extends BasePage {

    private final RightClickPage rightClickPage;

    public RightClickSteps (RightClickPage rightClickPage) {
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

    @When("click all the {string} available in the right click")
    public void click_all_the_available_in_the_right_click(String optionText) {
        rightClickPage.clickRightClickOption(optionText);
    }

    @Then("switch to {string} and verify it")
    public void switch_to_and_verify_it(String string) {
        rightClickPage.switchToAlertAndVerifyIt(string);
    }
}
