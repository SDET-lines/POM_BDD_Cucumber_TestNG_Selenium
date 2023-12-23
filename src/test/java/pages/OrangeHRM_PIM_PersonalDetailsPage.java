package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRM_PIM_PersonalDetailsPage extends BasePage {

    @FindBy(xpath="//input[@name='firstName']")
    private WebElement firstNameTextField;

    @FindBy(xpath="//input[@name='middleName']")
    private WebElement middleNameTextField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextField;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement employeeID;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsButton;

    public OrangeHRM_PIM_PersonalDetailsPage() {
        super();
    }

    public String getFirstNameTextField() {
        return firstNameTextField.getAttribute("value");
    }

    public String getMiddleNameTextField() {
        return middleNameTextField.getAttribute("value");
    }

    public String getLastNameTextField() {
        return lastNameTextField.getAttribute("value");
    }

    public String getEmployeeNumberValue() {
        return employeeID.getAttribute("value");
    }

    public void clickContactDetailsButton() {
        clickElement(contactDetailsButton);
    }
}
