package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrangeHRM_DashboardPage extends BasePage {

    @FindBy(xpath = "//*[@class='oxd-sidepanel-body']/ul/li")
    private List<WebElement> allMainTabs;

    @FindBy(xpath = "(//*[@class='oxd-sidepanel-body']/ul/li)[8]")
    private WebElement dashboardTab;

    public OrangeHRM_DashboardPage() {
        super();
    }

    public List<WebElement> getAllMainTabs() {
        return allMainTabs;
    }

    public String getTextFromDashboardTab() {
        return getText(dashboardTab);
    }

    public void clickPIMInMainTabByIndex() {
        clickElementInListByIndex(allMainTabs, 1);
    }
}
