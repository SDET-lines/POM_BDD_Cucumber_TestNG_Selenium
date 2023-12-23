package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class OrangeHRM_AddEmployeePageSteps {

    private final OrangeHRM_DashboardPage dashboardPage;
    private final OrangeHRM_PIM_AddEmployeePage pimAddEmployeePage;
    private final OrangeHRM_PIM_EmployeeList_Page pimEmployeeListPage;
    private final OrangeHRM_PIM_PersonalDetailsPage pimPersonalDetailsPage;
    private final OrangeHRM_PIM_ContactDetailsPage pimContactDetailsPage;

    public OrangeHRM_AddEmployeePageSteps (OrangeHRM_DashboardPage dashboardPage,
                                           OrangeHRM_PIM_AddEmployeePage addEmployeePage,
                                           OrangeHRM_PIM_EmployeeList_Page pimEmployeeListPage,
                                           OrangeHRM_PIM_PersonalDetailsPage pimPersonalDetailsPage,
                                           OrangeHRM_PIM_ContactDetailsPage pimContactDetailsPage
                                           ) {
    this.dashboardPage = dashboardPage;
    this.pimAddEmployeePage = addEmployeePage;
    this.pimEmployeeListPage = pimEmployeeListPage;
    this.pimPersonalDetailsPage = pimPersonalDetailsPage;
    this.pimContactDetailsPage = pimContactDetailsPage;
    }

    @When("user clicks on PIM tab")
    public void user_clicks_on_pim_tab() {
       dashboardPage.clickPIMInMainTabByIndex();
    }

    @When("user clicks on Add Employee Button")
    public void user_click_on_add_employee_button() {
        pimEmployeeListPage.clickAddEmployeeButton();
    }

    @And("user fills out first, middle and last name")
    public void user_fills_out_first_middle_and_last_name() {
        pimAddEmployeePage.setFullName();
    }

    @And("user clicks on save")
    public void user_clicks_on_save() {
        pimContactDetailsPage.clickOnSaveButton();
    }

    @Then("user clicks on employee name")
    public void user_clicks_on_employee_name() {
        pimEmployeeListPage.clickTableFirstEmployeeName();
    }

    @Then("user validates new account got created with correct details")
    public void verifyNewAccountDetails() {

        String actualFirstName = pimPersonalDetailsPage.getFirstNameTextField();
        String actualMiddleName = pimPersonalDetailsPage.getMiddleNameTextField();
        String actualLastName = pimPersonalDetailsPage.getLastNameTextField();
        String actualEmployeeNumberValue = pimPersonalDetailsPage.getEmployeeNumberValue();

        String expectedFirstname = pimAddEmployeePage.getUniqueSetFirstName();
        String expectedMiddleName = pimAddEmployeePage.getUniqueSetMiddleName();
        String expectedLastName = pimAddEmployeePage.getUniqueSetLastName();

        Assert.assertEquals(actualFirstName, expectedFirstname);
        Assert.assertEquals(actualMiddleName, expectedMiddleName);
        Assert.assertEquals(actualLastName, expectedLastName);
        Assert.assertNotNull(actualEmployeeNumberValue);
    }

    @Then("user clicks on contact Details")
    public void user_clicks_on_contact_details() {
        pimPersonalDetailsPage.clickContactDetailsButton();
    }

    @Then("user clicks on edit and fill out address")
    public void user_clicks_on_edit_and_fill_out_address() {
        pimContactDetailsPage.FillOutAddress();
    }

    @Then("user verifies full address is displayed")
    public void verifyAddressIsDisplayed() {
        String actualStreetAddress = pimContactDetailsPage.getActualStreetAddress();
        String expectedStreetAddress = pimContactDetailsPage.getGeneratedAddress();

        String actualCountry = pimContactDetailsPage.getActualDisplayedCountry();
        String chosenCountryFromDropdown = pimContactDetailsPage.getChosenCountryFromDropdown();

        Assert.assertEquals(actualStreetAddress, expectedStreetAddress,"Address verification failed");
        Assert.assertEquals(actualCountry, chosenCountryFromDropdown,"Country verification failed");
    }
}
