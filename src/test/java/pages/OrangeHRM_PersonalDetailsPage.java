package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRM_PersonalDetailsPage extends BasePage {

    @FindBy(xpath = "//a[text()='Contact Details']")
    public WebElement contactDetailsButton;

    public OrangeHRM_PersonalDetailsPage() {
        super();
    }

    public void clickContactDetailsButton() {
        clickElement(contactDetailsButton);
    }
}
