package Steps;

import Utils.DriverManager;
import Utils.ReportManager;
import com.aventstack.extentreports.Status;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ReportManager.getInstance().testCaseStarts(scenario.getName());
    }


    @After
    public void tearDown() {
        ReportManager.getInstance().getTestInstance().log(Status.INFO,"TEST COMPLETE");
        DriverManager.getInstance().quitDriver();
    }

}
