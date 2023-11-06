package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class OrangeHRM_LoginPage extends BasePage {

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameTextInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']//div//p")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    public WebElement messageUnderUsernameField;

    @FindBy(xpath = "//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
    public WebElement messageUnderPasswordField;

    public OrangeHRM_LoginPage() {
        super();
    }

    public void navigateToHRM_LoginPage() {
        navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void setHRM_UsernameByFeatureFile(String string) {
        sendKeys(usernameTextInput, string);
    }

    public void setUsername() {
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
        setUsername();
        setPassword();
        clickLoginButton();
    }

    public String getTextUnderUsernameField() {
        return getTextFromWebElement(messageUnderUsernameField);
    }

    public String getTextUnderPasswordField() {
        return getTextFromWebElement(messageUnderPasswordField);
    }

    public String getTextFromErrorMessage() {
        return getTextFromWebElement(errorMessage);
    }
}
