package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class BasePage {

    private final int DEFAULT_EXPLICIT_TIMEOUT = 8;

    public BasePage() {
        PageFactory.initElements(getDriver(),this);
    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    public void navigateToURL(String URL) {
        getDriver().get(URL);
    }

    public void clear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }

    public void sendKeys (WebElement element, String textToSend) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToSend);
    }

    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getTextFromWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void clickElementInListByIndex(List<WebElement> elements, int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        // Wait for the presence of the list of elements
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

        // Check if the index is within the bounds of the list
        if (index >= 0 && index < elements.size()) {
            // Click the element at the specified index
            WebElement element = elements.get(index);
            element.click();
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for the list of elements.");
        }
    }

    public void dragAndDrop (WebElement drag, WebElement drop) {
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(drag, drop).perform();
    }

    public void rightClick (WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.contextClick(element).perform();
    }

    public void switchToFrame (WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public void acceptAlert() {
        Alert myAlert = getDriver().switchTo().alert();
        myAlert.accept();
    }

    public String generateRandomStringWithAllPossibleCharacters(int length) {

        String ALL_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/\\`~";
        SecureRandom random = new SecureRandom();

        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_CHARS.length());
            randomString.append(ALL_CHARS.charAt(index));
        }
        return randomString.toString();
    }
}

