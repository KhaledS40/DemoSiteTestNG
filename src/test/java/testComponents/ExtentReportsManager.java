package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentReportsManager {

    private static ExtentReports extent;

    public  static ExtentReports createInstance(){

        String fleName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports";
        new File(directory).mkdirs();
        String path = directory + fleName;
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK); // or any other them you can set

        extent = new ExtentReports();
        extent.setSystemInfo("Home", "Lets code it");
        extent.setSystemInfo("Browser", "Edge");
        extent.setSystemInfo("Tester", "Khaled");
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName(){

        Date d = new Date();
        String fileName = "_ " + d.toString().replace(":", "_")
                .replace(" ","_ ") + ".html";
        return fileName;
    }
}
