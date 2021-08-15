package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.sql.Timestamp;
import java.util.Date;

public class ReportManager {

    private static ReportManager myInstance = null;
    private static ExtentReports report = null;
    private static ExtentTest extentTest = null;

    private ReportManager() {

    }

    public static ReportManager getInstance() {
        if (myInstance == null) {
            myInstance = new ReportManager();
        }
        return myInstance;
    }

    public ExtentReports getReportInstance()
    {
        return report;
    }

    public ExtentTest getTestInstance()
    {
        return extentTest;
    }

    public void initialiseReportInstance()
    {
        report = new ExtentReports();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        ExtentSparkReporter sparkReport =
                new ExtentSparkReporter(ConfigurationManager.getProperty("html.report.location") + "/report" +
                        ts.toString().replaceAll("[\\s.:]", "") + ".html");
        report.attachReporter(sparkReport);
    }

    public void completeReport() {
        report.flush();
    }

    public void testCaseStarts(String testcaseName){
        extentTest = report.createTest(testcaseName);
    }

}
