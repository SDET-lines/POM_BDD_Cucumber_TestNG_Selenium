package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRM_PIM_AddEmployeePage extends BasePage {

    @FindBy(xpath="//input[@name='firstName']")
    private WebElement firstNameTextField;

    @FindBy(xpath="//input[@name='middleName']")
    private WebElement middleNameTextField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextField;

    private String uniqueSetFirstName;
    private String uniqueSetMiddleName;
    private String uniqueSetLastName;

    public OrangeHRM_PIM_AddEmployeePage() {
        super();
    }

    public void setFullName() {
        Faker fake = new Faker();
        uniqueSetFirstName = fake.name().firstName();
        uniqueSetMiddleName = fake.name().nameWithMiddle();
        uniqueSetLastName = fake.name().lastName();
        sendKeys(firstNameTextField, uniqueSetFirstName);
        sendKeys(middleNameTextField, uniqueSetMiddleName);
        sendKeys(lastNameTextField, uniqueSetLastName);
    }

    public String getUniqueSetFirstName() {
        return uniqueSetFirstName;
    }

    public String getUniqueSetMiddleName() {
        return uniqueSetMiddleName;
    }

    public String getUniqueSetLastName() {
        return uniqueSetLastName;
    }
}
