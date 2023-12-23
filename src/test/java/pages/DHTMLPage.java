package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DHTMLPage extends BasePage {

    @FindBy(id = "box1")
    private WebElement oslo;

    @FindBy (id = "box101")
    private WebElement norway;

    public DHTMLPage(){
       super();
    }

    public void navigateToDHTMLPage() {
        navigateToURL("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
    }

    public void dragAndDropCapitalToItsCountry() {
        dragAndDrop(oslo, norway);
    }

    public Boolean getCssValueOslo() {
        return oslo.getCssValue("background-color").contains("0, 255, 0");
    }
}
