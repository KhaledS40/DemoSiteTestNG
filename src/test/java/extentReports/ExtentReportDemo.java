package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

    private static ExtentReports extent;

    public static ExtentReports createInstance() {

        // start Reports
        ExtentHtmlReporter html = new ExtentHtmlReporter("extentReport.html");

        // create ExtentReports and attach report(s)
        extent = new ExtentReports();

        extent.attachReporter(html);

        return extent;
    }

    public static ExtentReports getInstance(){

        if (extent == null){

            createInstance();
        }

        return extent;

    }
}
