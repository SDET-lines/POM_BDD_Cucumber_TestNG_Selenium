package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class OrangeHRM_AddEmployeePageSteps {

    private final OrangeHRM_HomePage homePage;
    private final OrangeHRM_AddEmployeePage addEmployeePage;

    public OrangeHRM_AddEmployeePageSteps (OrangeHRM_HomePage homePage, OrangeHRM_AddEmployeePage addEmployeePage) {
    this.homePage = homePage;
    this.addEmployeePage = addEmployeePage;
    }

    @When("user clicks on PIM tab")
    public void user_clicks_on_pim_tab() {
       homePage.clickPIMInMainTabByIndex();
    }

    @When("user clicks on Add Employee Button")
    public void user_click_on_add_employee_button() {
        homePage.clickAddEmployeeButton();
    }

    @And("user fills out first, middle and last name")
    public void user_fills_out_first_middle_and_last_name() {
        addEmployeePage.setFullName();
    }

    @Then("user click on save")
    public void user_clicks_on_save() {
        addEmployeePage.clickOnSaveButton();
    }

    @Then("user validates new account got created with correct details")
    public void verifyNewAccountDetails() {
         Assert.assertEquals(addEmployeePage.getActualFirstName(), addEmployeePage.getUniqueSetFirstName());
         Assert.assertEquals(addEmployeePage.getActualMiddleName(), addEmployeePage.getUniqueSetMiddleName());
         Assert.assertEquals(addEmployeePage.getActualLastName(), addEmployeePage.getUniqueSetLastName());
         Assert.assertNotNull(addEmployeePage.getEmployeeNumberValue());
    }
}
