package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class OrangeHRM_LoginPage extends BasePage {

    @FindBy(xpath = "//*[@name='username']")
    private WebElement usernameTextInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']//div//p")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    private WebElement messageUnderUsernameField;

    @FindBy(xpath = "//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
    private WebElement messageUnderPasswordField;

    public OrangeHRM_LoginPage() {
        super();
    }

    public void navigateToHRM_LoginPage() {
        navigateToURL(ConfigurationReader.getProperty("url"));
    }

    public void setHRM_UsernameByFeatureFile(String string) {
        sendKeys(usernameTextInput, string);
    }

    public void setUsernameByPropertyFile() {
        sendKeys(usernameTextInput, ConfigurationReader.getProperty("username"));
    }

    public void setHRM_PasswordByFeatureFile(String string) {
        sendKeys(passwordTextInput, string);
    }

    public void setPassword() {
        sendKeys(passwordTextInput, ConfigurationReader.getProperty("password"));
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void logInToOrangeHRM() {
        navigateToHRM_LoginPage();
        setUsernameByPropertyFile();
        setPassword();
        clickLoginButton();
    }

    public String getTextUnderUsernameField() {
        return getText(messageUnderUsernameField);
    }

    public String getTextUnderPasswordField() {
        return getText(messageUnderPasswordField);
    }

    public String getTextFromErrorMessage() {
        return getText(errorMessage);
    }
}
