package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class TestListners extends BaseTest implements ITestListener {

    private static ExtentReports extent = ExtentReportsManager.createInstance();

    // we make it ThreadLocal because we this class ThreadSage if multiple class runs in parallel at the same time this class can handle it
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {

        String logText = "<b> TestMethod" + result.getMethod().getMethodName() + " Successful</b>";
        Markup mark = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS, mark);
    }

    public void onTestSkipped(ITestResult result) {

        String logText = "<b> TestMethod" + result.getMethod().getMethodName() + " Skipped</b>";
        Markup mark = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP, mark);
    }

    public void onTestFailure(ITestResult result) {

        String methodname = result.getMethod().getMethodName();
        String exception = Arrays.toString(result.getThrowable().getStackTrace());
        extentTest.get().fail("<details><summary><b><font color=red>Exception Occured, click to see details:" +
                "</font></b></summary>" + exception.replaceAll(",","<br>") + "</details> \n");

        String path = takeScreenshot(result.getMethod().getMethodName());

        extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        String logText = "<b> Test Method" + methodname + "Failed</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL, m);
    }

    public void onFinish(ITestContext context) {

        if (extent!= null){
            extent.flush();
        }
    }

    public String takeScreenshot(String methodName){

        String fileName = getScreenshotName(methodName);
        String directory = System.getProperty("user.dir") + "/screenshots/";
        new File(directory).mkdirs();
        String path = directory + fileName;
        try{
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(path));
            System.out.println("*********************");
            System.out.println("Screenshot stored at:" + path);
            System.out.println("*********************");
        } catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }
    public static String getScreenshotName(String methodName){

        Date d = new Date();
        String fileName = methodName + "_ " + d.toString().replace(":", "_")
                .replace(" ","_ ") + ".png";
        return fileName;
    }
}
