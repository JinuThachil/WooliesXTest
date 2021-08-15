package Pages;

import Utils.WebElementWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WoolsHomePage{

    WebDriver localdriver;

    @FindBy(linkText = "Insurance")
    WebElement pageBanner;

    @FindBy(xpath = "//div[@class='ww-product-nav']//li/a[text()=' Life Insurance']")
    WebElement lifeInsuranceTab;

    @FindBy(xpath  = "(//h4[text()=' Quotes']/parent::div//li/a[text()='Life Insurance'])[2]")
    WebElement quoteLifeInsuranceLink;

    public WoolsHomePage(WebDriver webdriver) {
        localdriver = webdriver;
    }

    public void navigatetoPage()
    {
        localdriver.navigate().to("https://insurance.woolworths.com.au/");
        localdriver.manage().window().maximize();
    }

    public void ispageloaded() {
        try {
            WebDriverWait waitforload= new WebDriverWait(localdriver,20);
            waitforload.until(ExpectedConditions.visibilityOf(pageBanner));
            System.out.println("Home Page load successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Page load unsuccessful");
            throw e;
        }
    }
    public void clickOnGetQuote()
    {
        WebElementWrapper.getInstance().click(quoteLifeInsuranceLink);
    }
    public void hoverOnMenu()
    {
        WebElementWrapper.getInstance().hover(lifeInsuranceTab);
    }
}

