package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightClickPage extends BasePage {

    @FindBy(className = "context-menu-one")
    private WebElement rightClickMeButton;

    public RightClickPage() {
        super();
    }

    public void navigateToRightClickPage() {
        navigateToURL("http://swisnl.github.io/jQuery-contextMenu/demo.html");
    }

    public void rightClickOnTheButton() {
        rightClick(rightClickMeButton);
    }

    public void clickRightClickOption(String optionText) {
        getDriver().findElement(By.xpath("//span[text()='" + optionText + "']")).click();
    }

    public String switchToAlertAcceptAndGetText() {
        Alert myAlert = getDriver().switchTo().alert();
        String alertText = myAlert.getText();
        myAlert.accept();
        return alertText;
    }
}
