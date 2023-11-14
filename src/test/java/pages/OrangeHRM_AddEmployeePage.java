package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRM_AddEmployeePage extends BasePage {

    private String uniqueSetFirstName;
    private String uniqueSetMiddleName;
    private String uniqueSetLastName;

    @FindBy(xpath="//input[@name='firstName']")
    private WebElement actualFirstName;

    @FindBy(xpath="//input[@name='middleName']")
    private WebElement actualMiddleName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement actualLastName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement employeeID;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

    public OrangeHRM_AddEmployeePage () {
        super();
    }

    public void setFullName() {
        Faker fake = new Faker();
        uniqueSetFirstName = fake.name().firstName();
        uniqueSetMiddleName = fake.name().nameWithMiddle();
        uniqueSetLastName = fake.name().lastName();
        sendKeys(actualFirstName, uniqueSetFirstName);
        sendKeys(actualMiddleName, uniqueSetMiddleName);
        sendKeys(actualLastName, uniqueSetLastName);
    }

    public String getEmployeeNumberValue() {
        return employeeID.getAttribute("value");
    }

    public String getActualFirstName() {
        return actualFirstName.getAttribute("value");
    }

    public String getUniqueSetFirstName() {
        return uniqueSetFirstName;
    }

    public String getActualMiddleName() {
        return actualMiddleName.getAttribute("value");
    }

    public String getUniqueSetMiddleName() {
        return uniqueSetMiddleName;
    }

    public String getActualLastName() {
        return actualLastName.getAttribute("value");
    }

    public String getUniqueSetLastName() {
        return uniqueSetLastName;
    }

    public void clickOnSaveButton() {
        clickElement(saveButton);
    }
}
