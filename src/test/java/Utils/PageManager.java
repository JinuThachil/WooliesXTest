package Utils;

import Pages.LifeInsuranceCoverOptionsPage;
import Pages.LifeInsuranceQuoteConsentPage;
import Pages.LifeInsuranceQuoteLandingPage;
import Pages.WoolsHomePage;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

    private static PageManager pageManager = null;
    private WoolsHomePage woolsHomePage = null;
    private LifeInsuranceQuoteConsentPage lifeInsuranceQuoteConsentPage = null;
    private LifeInsuranceQuoteLandingPage lifeInsuranceQuoteLandingPage = null;
    private LifeInsuranceCoverOptionsPage lifeInsuranceCoverOptionsPage = null;


    private PageManager() {
    }

    public static PageManager getInstance() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public WoolsHomePage getHomePage() {
        if (this.woolsHomePage == null) {
            this.woolsHomePage = PageFactory.initElements(DriverManager.getInstance().getMyWebDriver(), WoolsHomePage.class);
        }
        return this.woolsHomePage;
    }

    public LifeInsuranceQuoteConsentPage getLifeInsuraceQuoteConsentPage() {
        if (this.lifeInsuranceQuoteConsentPage == null) {
            this.lifeInsuranceQuoteConsentPage = PageFactory.initElements(DriverManager.getInstance().getMyWebDriver(), LifeInsuranceQuoteConsentPage.class);
            this.lifeInsuranceQuoteConsentPage.ispageloaded();
        }
        return this.lifeInsuranceQuoteConsentPage;
    }

    public LifeInsuranceQuoteLandingPage getLifeInsuranceQuoteLandingPage() {
        if (this.lifeInsuranceQuoteLandingPage == null) {
            this.lifeInsuranceQuoteLandingPage = PageFactory.initElements(DriverManager.getInstance().getMyWebDriver(), LifeInsuranceQuoteLandingPage.class);
            this.lifeInsuranceQuoteLandingPage.ispageloaded();
        }

        return this.lifeInsuranceQuoteLandingPage;
    }

    public LifeInsuranceCoverOptionsPage getLifeInsuranceCoverOptionsPage() {
        if (this.lifeInsuranceCoverOptionsPage == null) {
            this.lifeInsuranceCoverOptionsPage = PageFactory.initElements(DriverManager.getInstance().getMyWebDriver(), LifeInsuranceCoverOptionsPage.class);
            this.lifeInsuranceCoverOptionsPage.ispageloaded();
        }
        return this.lifeInsuranceCoverOptionsPage;
    }

}
