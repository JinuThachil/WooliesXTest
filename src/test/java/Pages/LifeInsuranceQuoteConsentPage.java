package Pages;

import Utils.WebElementWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LifeInsuranceQuoteConsentPage {

    WebDriver localdriver;

    @FindBy(tagName = "input")
    WebElement checkBoxConsent;

    @FindBy(xpath = "//button[text()='Get a quote now']")
    WebElement buttonGetAQuoteNow;

    public LifeInsuranceQuoteConsentPage(WebDriver webDriver)
    {
        localdriver = webDriver;
    }

    public void ispageloaded() {
        try {
            WebDriverWait waitforload= new WebDriverWait(localdriver,20);
            waitforload.until(ExpectedConditions.visibilityOf(buttonGetAQuoteNow));
            System.out.println("LifeInsuranceQuoteConsentPage load successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LifeInsuranceQuoteConsentPage load unsuccessful");
            throw e;
        }
    }
    public void clickOnConsentCheckBox()
    {
        WebElementWrapper.getInstance().click(checkBoxConsent);
    }

    public void clickGetQuoteButton() {
        WebElementWrapper.getInstance().click(buttonGetAQuoteNow);
    }
}