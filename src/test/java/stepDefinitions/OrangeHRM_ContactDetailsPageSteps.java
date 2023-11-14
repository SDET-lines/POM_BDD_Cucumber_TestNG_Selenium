package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_ContactDetailsPage;
import pages.OrangeHRM_PersonalDetailsPage;

public class OrangeHRM_ContactDetailsPageSteps {

    private final OrangeHRM_HomePage homePage;
    private final OrangeHRM_PersonalDetailsPage personalDetailsPage;
    private final OrangeHRM_ContactDetailsPage contactDetailsPage;

    public OrangeHRM_ContactDetailsPageSteps(OrangeHRM_HomePage homePage,
                                             OrangeHRM_PersonalDetailsPage personalDetailsPage,
                                             OrangeHRM_ContactDetailsPage contactDetailsPage) {
        this.homePage=homePage;
        this.personalDetailsPage=personalDetailsPage;
        this.contactDetailsPage=contactDetailsPage;
    }

    @Then("user clicks on employee name")
    public void user_clicks_on_employee_name() {
        homePage.clickTableFirstEmployeeName();
    }

    @Then("user clicks on contact Details")
    public void user_clicks_on_contact_details() {
        personalDetailsPage.clickContactDetailsButton();
    }

    @Then("user clicks on edit and fill out address")
    public void user_clicks_on_edit_and_fill_out_address() {
        contactDetailsPage.clickEditAndFillOutAddress();
    }

    @And("user clicks on save")
    public void user_clicks_on_save() {
        contactDetailsPage.clickSaveButton();
    }

    @Then("user verifies full address is displayed")
    public void verifyAddressIsDisplayed() {
        Assert.assertEquals(contactDetailsPage.getActualStreetAddress(), contactDetailsPage.getAddress(),
                "Displaying chosen address verification failed");
        Assert.assertEquals(contactDetailsPage.getActualDisplayedCountry(), contactDetailsPage.getChosenCountryFromDropdown(),
                "Displaying chosen country verification failed");
    }
}
