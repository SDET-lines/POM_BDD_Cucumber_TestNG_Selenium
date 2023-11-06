package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowOpenedPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "englishchbx")
    public WebElement englishCheckBox;

    @FindBy(id = "registerbtn")
    public WebElement registerButton;

    @FindBy(id = "msg")
    public WebElement verificationMessage;

    public NewWindowOpenedPage(){
        super();
    }

    public void fillOutFirstNameAndLastNameAndChooseEnglishLanguage(String firstName, String lastName) {
        // driver.manage().window().maximize();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        englishCheckBox.click();
    }

    public void clickRegisterButton() {
        clickElement(registerButton);
    }

    public String getTextFromVerificationMessage() {
        return verificationMessage.getText();
    }
}


