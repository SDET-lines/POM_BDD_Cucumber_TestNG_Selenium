package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JqueryTooltipPage extends BasePage {

    @FindBy(xpath = "//*[@class='demo-frame']")
    private WebElement iframe;

    @FindBy(id = "age")
    private WebElement ageTextBox;

    @FindBy(className = "ui-tooltip-content")
    private WebElement tooltip;

    public JqueryTooltipPage() {
        super();
    }

    public void navigateToJqueryTooltipPage() {
        navigateToURL("https://jqueryui.com/tooltip/");
    }

    public void switchToTheIframe() {
        switchToFrame(iframe);
    }

    public void hoverOverTheField() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(ageTextBox).perform();
    }

    public String getTextTooltip() {
        return tooltip.getText();
    }

}

