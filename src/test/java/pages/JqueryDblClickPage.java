package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JqueryDblClickPage extends BasePage {

    @FindBy(css = "iframe[width='100%']")
    private WebElement demo_iframe;

    @FindBy(xpath = "//span[text()='Double click the block']//preceding-sibling::div")
    private WebElement block;

    public JqueryDblClickPage() {
        super();
    }

    public void navigateToJqueryDblClickPage() {
        navigateToURL("http://api.jquery.com/dblclick/");
    }

    public void switchToTheDemoIframeWithScrolling() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", demo_iframe);
        jse.executeScript("window.scrollBy(0, -50)");
        getDriver().switchTo().frame(demo_iframe);
    }

    public void doubleClickTheBox() {
        Actions actions = new Actions(getDriver());
        actions.doubleClick(block).perform();
    }

    public Boolean getCssValueBlock() {
        return block.getCssValue("background").contains("255, 255, 0");
    }
}
