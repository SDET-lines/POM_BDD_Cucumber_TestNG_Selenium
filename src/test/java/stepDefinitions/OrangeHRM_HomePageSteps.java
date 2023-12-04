package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.OrangeHRM_HomePage;
import java.util.List;
import java.util.Map;

public class OrangeHRM_HomePageSteps {

    private final OrangeHRM_HomePage homePage;

    public OrangeHRM_HomePageSteps (OrangeHRM_HomePage homePage) {
        this.homePage=homePage;
    }

    @And("user verifies main tabs on OrangeHRM Homepage via ListOfMaps")
    public void user_verifies_main_tabs_on_HRM_Homepage_via_ListOfMaps(DataTable dataTable) {
        List <Map <String,String>> maps = dataTable.asMaps();
        homePage.verifyMainTabsViaListOfMaps(maps);
    }

    @And("user verifies main tabs on OrangeHRM Homepage with ListOfData")
    public void user_verifies_main_tabs_on_HRM_Homepage_with_ListOfData(DataTable dataTable) {
        List <String> listOfTabs = dataTable.asList();
        homePage.verifyMainTabsViaListOfData(listOfTabs);
    }

    @Then("user should be able to verify Dashboard active tab on OrangeHRM Homepage")
    public void user_should_be_able_to_verify_dashboard_active_tab_on_orange_hrm_homepage() {
        Assert.assertEquals(homePage.getTextFromDashboardTab(), "Dashboard",
                "Dashboard tab verification failed");
    }
}
