package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class OrangeHRM_HomePage extends BasePage {

    @FindBy(xpath = "//*[@class='oxd-sidepanel-body']/ul/li")
    private List<WebElement> allMainTabs;

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[4]")
    private WebElement tableFirstEmployeeName;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardTab;

    public OrangeHRM_HomePage() {
        super();
    }

    public void clickPIMInMainTabByIndex() {
        clickElementInListByIndex(allMainTabs, 1);
    }

    public void clickAddEmployeeButton() {
        clickElement(addEmployeeButton);
    }

    public void clickTableFirstEmployeeName() {
        clickElement(tableFirstEmployeeName);
    }

    public String getTextFromDashboardTab() {
        return getText(dashboardTab);
    }

    public void verifyMainTabsViaListOfMaps(List <Map <String,String>> maps) {

        int i = 0;

        for ( Map<String, String> map : maps ) {
            String expectedTabName = map.get("TabName");
            String actualTabName = visibilityOfAllElements(allMainTabs).get(i).getText();
            Assert.assertEquals(actualTabName,expectedTabName, "TabName verification failed");
            i++;
        }
    }

    public void verifyMainTabsViaListOfData(List <String> listOfTabs) {

        int i = 0;

        for (String expectedTabName : listOfTabs) {
            String actualTabName = visibilityOfAllElements(allMainTabs).get(i).getText();
            Assert.assertEquals(actualTabName, expectedTabName, "TabName verification failed");
            i++;
        }
    }
}
