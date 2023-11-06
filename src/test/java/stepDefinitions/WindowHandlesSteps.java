package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.NewTabOpenedPage;
import pages.NewWindowOpenedPage;
import pages.WindowHandlesPage;

public class WindowHandlesSteps extends BasePage {

    private final WindowHandlesPage windowHandlesPage;
    private final NewWindowOpenedPage newWindowOpened;
    private final NewTabOpenedPage newTabOpened;

    public WindowHandlesSteps (WindowHandlesPage windowHandles, NewWindowOpenedPage newWindowOpenedPage,
                               NewTabOpenedPage newTabOpened) {
        this.windowHandlesPage =windowHandles;
        this.newWindowOpened=newWindowOpenedPage;
        this.newTabOpened=newTabOpened;
    }

    @Given("user navigates to the window site")
    public void user_navigates_to_the_window_site() {
        windowHandlesPage.navigateToWindowHandlesPage();
    }

    @When("user clicks on Open New Window button")
    public void user_clicks_on_open_new_window_button() {
        windowHandlesPage.clickOpenNewWindowButton();
    }

    @And("switch to the new window opened")
    public void switch_to_the_new_window_opened() {
        windowHandlesPage.switchToChildWindowOrNewTab();
    }

    @When("fills out {string}, {string}, choose English language")
    public void fills_out_fields_and_choose_english_language(String firstName, String lastName) {
       newWindowOpened.fillOutFirstNameAndLastNameAndChooseEnglishLanguage(firstName,lastName);
    }

    @And("click register button on the new opened page")
    public void click_register_button_on_the_new_opened_page() {
       newWindowOpened.clickRegisterButton();
    }

    @Then("verify message {string} is present")
    public void verify_message_is_present(String ExpectedMessage) {
        Assert.assertEquals(newWindowOpened.getTextFromVerificationMessage(), ExpectedMessage,
                "Verification message failed");
    }

    @When("close the window")
    public void close_the_window() {
        getDriver().close();
    }

    @And("return to the parent window")
    public void return_to_the_parent_window() {
       windowHandlesPage.returnToTheParentWindow();
    }

    @And("enter the text {string}")
    public void enter_the_text(String textToEnter) {
        windowHandlesPage.enterTextToTheTextBox(textToEnter);
    }

    @Then("verify the text is present")
    public void verify_the_text_is_present() {
        Assert.assertEquals(windowHandlesPage.getTextBoxValue(), windowHandlesPage.getTextEntered(),
                "Entered text verification failed");
    }

    @When("user clicks on Open New Tab button")
    public void user_clicks_on_open_new_tab_button() {
       windowHandlesPage.clickOpenNewTabButton();
    }

    @And("switch to the new tab opened")
    public void switch_to_the_new_tab_opened() {
        windowHandlesPage.switchToChildWindowOrNewTab();
    }

    @And("click button to display an alert box")
    public void click_button_to_display_an_alert_box() {
        newTabOpened.clickOnClickMeAlertBoxButton();
    }

    @And("handle alert")
    public void handle_alert() {
        acceptAlert();
    }

    @When("close the new tab")
    public void close_the_new_tab() {
        getDriver().close();
    }

    @Then("verify Popup box output {string}")
    public void verify_popup_box_output(String string) {
        Assert.assertEquals(newTabOpened.getTextPopUpBoxOutput(), string, "Popup box output does not match");
    }
}
