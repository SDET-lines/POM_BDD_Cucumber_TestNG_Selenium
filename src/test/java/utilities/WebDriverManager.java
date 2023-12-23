package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(selectDriver());
        }
        return webDriver.get();
    }

    private static WebDriver selectDriver() {
        WebDriver driver;
        String browserType = ConfigurationReader.getProperty("browser").toLowerCase().trim();

        switch (browserType) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}



