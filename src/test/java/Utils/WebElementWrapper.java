package Utils;

import com.google.common.base.Function;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebElementWrapper {


    private static WebElementWrapper myInstance = null;

    private WebElementWrapper() {

    }

    public static WebElementWrapper getInstance() {
        if (myInstance == null) {
            myInstance = new WebElementWrapper();
        }
        return myInstance;
    }

    public void click(WebElement element) {
        try {
            if (waitForElement(element))
                element.click();
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void hover(WebElement element) {
        try {
            if(waitForElement(element)) {
                Actions selAction = new Actions(DriverManager.getInstance().getMyWebDriver());
                selAction.moveToElement(element).perform();
            }
        } catch (TimeoutException e) {
            Assert.fail();
        }
    }

    public boolean waitForElement(WebElement element) {
        try {
                WebDriverWait waitForElement = new WebDriverWait(DriverManager.getInstance().getMyWebDriver(), 20);
                waitForElement.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element), ExpectedConditions.elementToBeClickable(element)));
        } catch (Exception e) {
            Assert.fail("Element not displayed or enabled");
        }
        return true;
    }

    public void sendKeys(WebElement element, String text) {
        try {
            if (waitForElement(element))
                element.sendKeys(text);
        } catch (Exception e) {
            Assert.fail("Element not displayed or enabled");
        }
    }

    public String getText(WebElement element) {
        try {
            if (waitForElement(element))
               return  element.getText();
        } catch (Exception e) {
            Assert.fail("Element not displayed or enabled");
        }
        return null;
    }

    public void isPageUp() {
        ExpectedCondition<Boolean> pageLoadCondition =
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getMyWebDriver(), 10);
        wait.until((Function) pageLoadCondition);
    }
}
