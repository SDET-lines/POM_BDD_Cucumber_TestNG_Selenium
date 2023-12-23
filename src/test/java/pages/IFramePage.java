package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {

    @FindBy(id="mce_0_ifr")
    private WebElement iFrame;

    @FindBy(id="tinymce")
    private WebElement iFrameTextInput;

    public String randomTextToEnter;

    public IFramePage(){
        super();
    }

    public void navigateToIFramePage() {
        navigateToURL("https://the-internet.herokuapp.com/iframe");
    }

    public void setSpecifiedQuantityOfRandomText(int length) {
        switchToFrame(iFrame);
        randomTextToEnter = generateRandomStringWithAllPossibleCharacters(length);
        clear(iFrameTextInput);
        sendKeys(iFrameTextInput, randomTextToEnter);
    }

    public String getRandomTextToEnter() {
        return randomTextToEnter;
    }

    public String getTextEntered() {
        return iFrameTextInput.getText();
    }
}
