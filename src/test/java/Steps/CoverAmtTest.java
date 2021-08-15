package Steps;

import Utils.DriverManager;
import Utils.PageManager;
import Utils.ReportManager;
import com.aventstack.extentreports.Status;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CoverAmtTest {
    @Given("^the user opens the Woolworths Insurance Webpage$")
    public void theUserOpensTheWoolworthsInsuranceWebpage() {
        PageManager.getInstance().getHomePage().navigatetoPage();
        ReportManager.getInstance().getTestInstance().log(Status.INFO,"Given the user opens the Woolworths Insurance Webpage");
    }

    @And("then navigates to Life Insurance Quotes Page")
    public void thenNavigatesToLifeInsuranceQuotesPage() {
            PageManager.getInstance().getHomePage().ispageloaded();
            PageManager.getInstance().getHomePage().hoverOnMenu();
            PageManager.getInstance().getHomePage().clickOnGetQuote();
            ReportManager.getInstance().getTestInstance().log(Status.INFO,"And then navigates to Life Insurance Quotes Page");
    }
    @And("confirms Age Eligibility to proceed")
    public void confirmsAgeEligibilityToProceed() {
            PageManager.getInstance().getLifeInsuraceQuoteConsentPage().ispageloaded();
            PageManager.getInstance().getLifeInsuraceQuoteConsentPage().clickOnConsentCheckBox();
            PageManager.getInstance().getLifeInsuraceQuoteConsentPage().clickGetQuoteButton();
            ReportManager.getInstance().getTestInstance().log(Status.INFO,"And confirms Age Eligibility to proceed");
    }

    @And("enters the following details and requests for quote")
    public void entersTheFollowingDetailsAndRequestsForQuote(DataTable userDetails) throws InterruptedException {
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().ispageloaded();
            List<Map<String, String>> rows = userDetails.asMaps(String.class, String.class);
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().inputFirstName(rows.get(0).get("NAME"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().inputDOB(rows.get(0).get("DOB"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().selectSmokerOption(rows.get(0).get("SMOKER"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().selectGenderOption(rows.get(0).get("GENDER"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().selectIncome(rows.get(0).get("ANNINCOME"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().clickCoverageDropDown();
//            Thread.sleep(2000);
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().selectCoverAmount(rows.get(0).get("COVERAMT"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().setCoverAmt(rows.get(0).get("COVERAMT"));
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().clickConsentCheckBox();
            PageManager.getInstance().getLifeInsuranceQuoteLandingPage().clickContinueButton();
            ReportManager.getInstance().getTestInstance().log(Status.INFO,"And enters the following details and requests for quote");
            //wrapper for hardwait?

    }

    @Then("the selected amount is displayed")
    public void theSelectedAmountIsDisplayed() {
        String ExpectedCoverAmount = PageManager.getInstance().getLifeInsuranceQuoteLandingPage().getCoverAmt();
        Assert.assertEquals("Cover Amount is incorrect", ExpectedCoverAmount,
                PageManager.getInstance().getLifeInsuranceCoverOptionsPage().getSelectedCoverAmount());
        ReportManager.getInstance().getTestInstance().log(Status.INFO,"And the selected amount is displayed");
    }

    @And("the quotes are displayed in ascending order")
    public void theQuotesAreDisplayedInAscendingOrder() {
        PageManager.getInstance().getLifeInsuranceCoverOptionsPage().verifyOrder();
        ReportManager.getInstance().getTestInstance().log(Status.INFO,"Then the quotes are displayed in ascending order");
    }
}
