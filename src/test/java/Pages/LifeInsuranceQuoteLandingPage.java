package Pages;

import Utils.DriverManager;
import Utils.WebElementWrapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LifeInsuranceQuoteLandingPage {


    WebDriver localdriver;

    @FindBy(xpath = "//div[text()='About you, the basics']")
    WebElement pageBanner;

    @FindBy(xpath = "//input[@name='FirstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='dateofbirth']")
    WebElement dobInput;

    @FindBy(xpath = "(//label[text()='Yes'])[1]")
    WebElement smokerYesOption;

    @FindBy(xpath = "(//label[text()='No'])[1]")
    WebElement smokerNoOption;

    @FindBy(xpath = "(//label[text()='Male'])")
    WebElement genderMaleOption;

    @FindBy(xpath = "(//label[text()='Female'])")
    WebElement genderFemaleOption;

    @FindBy(xpath = "(//label[text()='Yes'])[2]")
    WebElement incomeAboveOption;

    @FindBy(xpath = "(//label[text()='No'])[2]")
    WebElement incomeBelowOption;

    @FindBy(xpath = "//div[@class='reactSelect__value-container css-1hwfws3']")
    WebElement coverageDropDown;

    @FindBy(xpath = "//input[@name='PCNChecked']")
    WebElement consentCheckBox;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    @Getter
    @Setter
    String CoverAmt;


    public LifeInsuranceQuoteLandingPage(WebDriver webDriver) {
        localdriver = webDriver;
    }


    public void ispageloaded() {
        try {
            WebDriverWait waitforload = new WebDriverWait(localdriver, 20);
            waitforload.until(ExpectedConditions.visibilityOf(pageBanner));
            System.out.println("LifeInsuranceQuoteLandingPage load successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LifeInsuranceQuoteLandingPage unsuccessful");
            throw e;
        }
    }

    public void inputFirstName(String name) {
        WebElementWrapper.getInstance().sendKeys(firstNameInput, name);
    }

    public void inputDOB(String dob) {
        WebElementWrapper.getInstance().sendKeys(dobInput, dob);
    }

    public void selectSmokerOption(String option) {
        if (option.equals("Yes"))
            smokerYesOption.click();
        else if (option.equals("No"))
            smokerNoOption.click();
        else
            Assert.fail("Incorrect Smoker Option, input Yes or No");
    }

    public void selectGenderOption(String option) {
        if (option.equals("Male"))
            WebElementWrapper.getInstance().click(genderMaleOption);
        else if (option.equals("Female"))
            WebElementWrapper.getInstance().click(genderFemaleOption);
        else
            Assert.fail("Incorrect Gender Option, input Male or Female");
    }

    public void selectIncome(String option) {
        if (option.equals("Yes"))
            WebElementWrapper.getInstance().click(incomeAboveOption);
        else if (option.equals("No"))
            WebElementWrapper.getInstance().click(incomeBelowOption);
        else
            Assert.fail("Incorrect Income Option, input Yes or No");
    }

    public void selectCoverAmount(String coverPrice) {
        String optionXPATH = "//div[text()='" + coverPrice + "']";
        List<WebElement> options = DriverManager.getInstance().getMyWebDriver().findElements(By.xpath(optionXPATH));
        if (options.size() == 0)
            Assert.fail("Incorrect CoverAmount Passed");
        else
            WebElementWrapper.getInstance().click(options.get(0));
    }

    public void clickCoverageDropDown() {
        WebElementWrapper.getInstance().click(coverageDropDown);
    }

    public void clickConsentCheckBox() {
        WebElementWrapper.getInstance().click(consentCheckBox);
    }

    public void clickContinueButton() {
        WebElementWrapper.getInstance().click(continueButton);
    }
}
