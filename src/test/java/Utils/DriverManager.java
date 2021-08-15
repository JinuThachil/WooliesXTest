package Utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    private static DriverManager myInstance = null;

    @Getter
    private WebDriver myWebDriver = null;

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (myInstance == null)
            myInstance = new DriverManager();
        return myInstance;
    }

    public void createDriver(String browserType) {
        browserType = browserType.toUpperCase();
        switch (browserType) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", ConfigurationManager.getProperty("driver.location"));
                break;
            default:
                break;
        }
        myWebDriver = new ChromeDriver();
        myWebDriver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigurationManager.getProperty("implicit.wait")), TimeUnit.SECONDS);
        myWebDriver.manage().window().maximize();
    }

    public void quitDriver() {
        myWebDriver.quit();
    }

    public void closeDriver() {
        myWebDriver.close();
    }
}
