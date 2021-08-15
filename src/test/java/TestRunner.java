import Utils.ConfigurationManager;
import Utils.DriverManager;
import Utils.ReportManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class TestRunner {


    @BeforeClass
    public static void setup() throws IOException {
        ConfigurationManager.loadProperties();
        DriverManager.getInstance().createDriver(ConfigurationManager.getProperty("driver.type"));
        ReportManager.getInstance().initialiseReportInstance();
    }

    @AfterClass
    public static void tearDown(){
        ReportManager.getInstance().completeReport();
    }
}