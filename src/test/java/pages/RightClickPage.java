package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightClickPage extends BasePage {

   // private final WebDriver driver = getDriver();

    @FindBy(css = "span[class='context-menu-one btn btn-neutral']")
    public WebElement rightClickButton;

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

    public void switchToAlertAndVerifyIt(String string) {
        Alert myAlert = getDriver().switchTo().alert();
        Assert.assertEquals(string, myAlert.getText());
        myAlert.accept();
    }
}
