package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    static ExtentReports extent;

    public static ExtentReports getReporterObject(){

        String path = System.getProperty("user.dir") + "\\test-results\\Result.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Neiman-Marcus Test Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA", "Automation Team");
        return extent;
    }

}


