package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRM_PIM_EmployeeList_Page extends BasePage{

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addButton;

    @FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[4]")
    private WebElement tableFirstEmployeeName;

    public OrangeHRM_PIM_EmployeeList_Page() {
        super();
    }

    public void clickAddEmployeeButton() {
        clickElement(addButton);
    }

    public void clickTableFirstEmployeeName() {
        clickElement(tableFirstEmployeeName);
    }
}
