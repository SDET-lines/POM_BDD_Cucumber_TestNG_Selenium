package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    @FindBy(tagName = "body")
    private WebElement bodyOfAnyFrame;

    public NestedFramesPage () {
        super();
    }

    public void navigateToNestedFramesPage() {
        navigateToURL("https://the-internet.herokuapp.com/nested_frames");
    }

    public void switchToLeftFrame() {
        switchToFrame("frame-top");
        switchToFrame("frame-left");
    }

    public String getFrameText() {
        return bodyOfAnyFrame.getText();
    }
}
