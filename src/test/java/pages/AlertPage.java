package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertPage extends BasePage {

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy (id = "promtButton")
    private WebElement promptButton;

    public AlertPage (){
        super();
    }

    public void navigateToAlertPage() {
        navigateToURL("https://demoqa.com/alerts");
    }

    public void clickOnTheCorrespondingAlertType(String alertType) {
        switch (alertType) {
            case "regular" -> clickElement(alertButton);
            case "timer"   -> clickElement(timerAlertButton);
            case "confirm" -> clickElement(confirmButton);
            case "prompt"  -> clickElement(promptButton);
            default -> throw new IllegalArgumentException("Invalid alert type: " + alertType);
        }
    }

    public void waitForAlertAndValidateText(String expectedAlertText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(8));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert myAlert = getDriver().switchTo().alert();
        try {
            Assert.assertEquals(myAlert.getText(), expectedAlertText);
        } finally {
            myAlert.accept();
        }
    }
}
