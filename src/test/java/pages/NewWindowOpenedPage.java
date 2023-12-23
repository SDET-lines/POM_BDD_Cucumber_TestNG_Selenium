package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowOpenedPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "englishchbx")
    private WebElement englishCheckBox;

    @FindBy(id = "registerbtn")
    private WebElement registerButton;

    @FindBy(id = "msg")
    private WebElement verificationMessage;

    public NewWindowOpenedPage(){
        super();
    }

    public void fillOutFirstNameAndLastNameAndChooseEnglishLanguage(String firstName, String lastName) {
        sendKeys(firstNameField, firstName);
        sendKeys(lastNameField, lastName);
        clickElement(englishCheckBox);
    }

    public void clickRegisterButton() {
        clickElement(registerButton);
    }

    public String getTextFromVerificationMessage() {
        return verificationMessage.getText();
    }

    public void closeWindow() {
        closeTabOrWindow();
    }
}


