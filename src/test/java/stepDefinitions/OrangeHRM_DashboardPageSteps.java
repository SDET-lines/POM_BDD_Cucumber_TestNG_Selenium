package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.OrangeHRM_DashboardPage;
import java.util.List;
import java.util.Map;

public class OrangeHRM_DashboardPageSteps {

    private final OrangeHRM_DashboardPage dashboardPage;

    public OrangeHRM_DashboardPageSteps(OrangeHRM_DashboardPage dashboardPage) {
        this.dashboardPage =dashboardPage;
    }

    @And("user validates main tabs on Dashboard Page via ListOfMaps")
    public void user_validates_main_tabs_on_Dashboard_Page_via_ListOfMaps(DataTable dataTable) {
        List <Map<String, String>> maps = dataTable.asMaps();
        int i = 0;
        for (Map<String, String> map : maps) {
            String actualTabName = dashboardPage.getAllMainTabs().get(i).getText();
            String expectedTabName = map.get("TabName");
            Assert.assertEquals(actualTabName, expectedTabName, "TabName verification failed");
            i++;
        }
    }

    @And("user validates main tabs on Dashboard Page via ListOfData")
    public void user_validates_main_tabs_on_Dashboard_Page_via_ListOfData(DataTable dataTable) {
        List<String> listOfTabs = dataTable.asList();
        int i = 0;
        for (String expectedTabName : listOfTabs) {
            String actualTabName = dashboardPage.getAllMainTabs().get(i).getText();
            Assert.assertEquals(actualTabName, expectedTabName, "TabName verification failed");
            i++;
        }
    }
}
