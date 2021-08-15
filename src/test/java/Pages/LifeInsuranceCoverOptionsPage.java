package Pages;

import Utils.WebElementWrapper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LifeInsuranceCoverOptionsPage{

    WebDriver localdriver;

    @FindBy(xpath = "//div[text()='Please select your cover amount  and payment frequency']")
    WebElement pageTitle;

    @FindBy(xpath = "//div[@class='reactSelect__single-value css-1uccc91-singleValue']")
    WebElement selectedCoverAmt;

    @FindBy(xpath = "//div[@class='reactSelect__menu-list css-11unzgr']")
    WebElement elementDropDownList;
    //do you need this?

    @FindBy(xpath = "//div[@class='reactSelect__menu-list css-11unzgr']/div")
    List<WebElement> listAmountValues;


    public LifeInsuranceCoverOptionsPage(WebDriver webDriver)
    {
        localdriver = webDriver;
    }

    public void ispageloaded() {
        try {
            WebDriverWait waitforload= new WebDriverWait(localdriver,20);
            waitforload.until(ExpectedConditions.visibilityOf(pageTitle));
            System.out.println("LifeInsuraceQuoteConsentPage load successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LifeInsuraceQuoteConsentPage load unsuccessful");
            throw e;
        }
    }
    public String getSelectedCoverAmount()
    {
        return WebElementWrapper.getInstance().getText(selectedCoverAmt);
    }

    public void verifyOrder(){
        WebElementWrapper.getInstance().click(selectedCoverAmt);
        List<String> actualList = listAmountValues.stream().map(element -> element.getText()).toList();
        System.out.println(actualList.toString());
        List<String> expectedSortedList = listAmountValues.stream().map(element -> element.getText()).sorted().toList();
        System.out.println(expectedSortedList.toString());
        Assert.assertEquals("Lists have different order", actualList, expectedSortedList);
        System.out.println("Lists have the same order");
    }

}
