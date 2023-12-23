package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTabOpenedPage extends BasePage {

    @FindBy(id = "alertBox")
    private WebElement clickMeAlertBoxButton;

    @FindBy(id = "output")
    private WebElement popUpBoxOutput;

    public NewTabOpenedPage(){
        super();
    }

    public void clickOnClickMeAlertBoxButton() {
        clickElement(clickMeAlertBoxButton);
    }

    public void closeAlert() {
        acceptAlert();
    }

    public String getTextPopUpBoxOutput() {
       return getText(popUpBoxOutput);
    }

    public void CloseTab() {
        closeTabOrWindow();
    }
}
