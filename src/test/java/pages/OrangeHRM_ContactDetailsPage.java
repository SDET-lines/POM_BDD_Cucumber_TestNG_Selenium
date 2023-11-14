package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.Random;

public class OrangeHRM_ContactDetailsPage extends BasePage {

    private String address;
    private String textOfRandomCountryFromDropDown;

    @FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[1]//div[1]//div[2]//input[1]")
    private WebElement addressStreet;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    private WebElement selectButton;

    @FindBy(xpath = "//div[@role='option']")
    private List <WebElement> countryDropdownOptions;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement actualDisplayedCountryFromDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public OrangeHRM_ContactDetailsPage() {
        super();
    }

    public void clickSaveButton() {
        clickElement(saveButton);
    }

    public void clickAddressStreet() {
        clickElement(addressStreet);
    }

    public void clearAddressStreet() {
        clear(addressStreet);
    }

    public void sendTextToAddressStreet()  {
        Faker fake = new Faker();
        address = fake.address().streetAddress();
        sendKeys(addressStreet, address);
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

    public void clickEditAndFillOutAddress() {
        clickAddressStreet();
        clearAddressStreet();
        sendTextToAddressStreet();
        clickSelectButton();
       clickSelectedCountryFromDropdown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAddress() {
        return address;
    }

    public String getActualStreetAddress() {
        return addressStreet.getAttribute("value");
    }

    public String getActualDisplayedCountry() {
        return actualDisplayedCountryFromDropdown.getText();
    }

    public String getChosenCountryFromDropdown() {
        return textOfRandomCountryFromDropDown;
    }
}
