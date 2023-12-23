package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlesPage extends BasePage {

    @FindBy(id = "newWindowBtn")
    private WebElement openNewWindowButton;

    @FindBy(id = "newTabBtn")
    private WebElement openNewTabButton;

    @FindBy(id = "name")
    private WebElement textBox;

    private String parentWindowID;
    private String textEntered;

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
        switchToWindow(childWindowID);
        getDriver().manage().window().maximize();
    }

    private void returnToTheParentWindow() {
        switchToWindow(parentWindowID);
    }

    public void enterTextToTheTextBox(String textToEnter) {
        returnToTheParentWindow();
        textEntered = textToEnter;
        sendKeys(textBox, textToEnter);
    }

    public String getTextEntered() {
        return textEntered;
    }

    public String getTextBoxValue() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        return (String) jsExecutor.executeScript("return arguments[0].value;",textBox);
    }

    public void clickOpenNewTabButton() {
        clickElement(openNewTabButton);
    }
}
