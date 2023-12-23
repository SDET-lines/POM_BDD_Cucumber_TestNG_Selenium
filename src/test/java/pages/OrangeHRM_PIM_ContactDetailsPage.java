package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.Random;

public class OrangeHRM_PIM_ContactDetailsPage extends BasePage {

    @FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[1]//div[1]//div[2]//input[1]")
    private WebElement streetAddress;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    private WebElement selectButton;

    @FindBy(xpath = "//div[@role='option']")
    private List <WebElement> countryDropdownOptions;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement actualDisplayedCountryFromDropdown;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

    private String generatedAddress;
    private String textOfRandomCountryFromDropDown;

    public OrangeHRM_PIM_ContactDetailsPage() {
        super();
    }

    public void clickStreetAddress() {
        clickElement(streetAddress);
    }

    public void clearStreetAddress() {
        clear(streetAddress);
    }

    public void sendTextToStreetAddress()  {
        Faker fake = new Faker();
        generatedAddress = fake.address().streetAddress();
        sendKeys(streetAddress, generatedAddress);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickSelectButton() {
        clickElement(selectButton);
    }

    public void clickSelectedCountryFromDropdown() {
        int randomIndex = new Random().nextInt(countryDropdownOptions.size());
        WebElement randomCountryFromDropDown = countryDropdownOptions.get(randomIndex);
        textOfRandomCountryFromDropDown = randomCountryFromDropDown.getText();
        clickElement(randomCountryFromDropDown);
    }

    public void FillOutAddress() {
        clickStreetAddress();
        clearStreetAddress();
        sendTextToStreetAddress();
        clickSelectButton();
       clickSelectedCountryFromDropdown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getGeneratedAddress() {
        return generatedAddress;
    }

    public String getActualStreetAddress() {
        return streetAddress.getAttribute("value");
    }

    public String getActualDisplayedCountry() {
        return actualDisplayedCountryFromDropdown.getText();
    }

    public String getChosenCountryFromDropdown() {
        return textOfRandomCountryFromDropDown;
    }

    public void clickOnSaveButton() {
        clickElement(saveButton);
    }
}
