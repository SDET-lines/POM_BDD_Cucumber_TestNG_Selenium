package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlesPage extends BasePage {

    private String parentWindowID;
    private String textEntered;

    @FindBy(id = "newWindowBtn")
    public WebElement openNewWindowButton;

    @FindBy(id = "newTabBtn")
    public WebElement openNewTabButton;

    @FindBy(id = "name")
    public WebElement textBox;

    public WindowHandlesPage(){
        super();
    }

    public void navigateToWindowHandlesPage() {
        navigateToURL("https://www.hyrtutorials.com/p/window-handles-practice.html");
    }

    public void clickOpenNewWindowButton() {
        clickElement(openNewWindowButton);
    }

    public void switchToChildWindowOrNewTab() {
        Set <String> windowIDs = getDriver().getWindowHandles();
        Iterator <String> it = windowIDs.iterator();
        parentWindowID = it.next();
        String childWindowID = it.next();
        getDriver().switchTo().window(childWindowID);
    }

    public void returnToTheParentWindow() {
        getDriver().switchTo().window(parentWindowID);
    }

    public void enterTextToTheTextBox(String textToEnter) {
        textEntered = textToEnter;
        sendKeys(textBox, textToEnter);
    }

    public String getTextBoxValue() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        return (String) jsExecutor.executeScript("return arguments[0].value;",textBox);
    }

    public String getTextEntered() {
        return textEntered;
    }

    public void clickOpenNewTabButton() {
        clickElement(openNewTabButton);
    }
}
