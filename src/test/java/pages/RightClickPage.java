package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightClickPage extends BasePage {

    @FindBy(css = "span[class='context-menu-one btn btn-neutral']")
    private WebElement rightClickButton;

    @FindBy(xpath = "//span")
    private WebElement rightClickOptions;

    public RightClickPage() {
        super();
    }

    public void navigateToRightClickPage() {
        navigateToURL("http://swisnl.github.io/jQuery-contextMenu/demo.html");
    }

    public void rightClickOnTheButton() {
        rightClick(rightClickButton);
    }

    public void clickRightClickOption(String optionText) {
        rightClickOptions.findElement(By.xpath("//span[text()='" + optionText + "']")).click();
    }

    public void switchToAlertAndVerifyIt(String expectedAlertText) {
        Alert myAlert = getDriver().switchTo().alert();
        Assert.assertEquals(myAlert.getText(), expectedAlertText, "Alert text verification failed");
        myAlert.accept();
    }
}
