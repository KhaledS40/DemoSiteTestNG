package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReportsDemo;

import java.io.IOException;


public class Listeners extends BaseTest implements ITestListener {

    /*
        .   Listener implement ITestListener which is an interface and has unimplemented methods
     */

    ExtentTest test ;
    ExtentReports extent = ExtentReportsDemo.ExtentReportFirstTest();

    @Override
    public void onTestStart(ITestResult result){

        // we have to give testcase name
        test = extent.createTest(result.getMethod().getMethodName());

    }
    @Override
    public void onTestSuccess(ITestResult result){

        // if any test success, it immediately comes here
        test.log(Status.PASS, " Test Passed");


    }
    @Override
    public void onTestFailure(ITestResult result){

        //test.log(Status.FAIL, " Test Failed");
            // or
        test.fail(result.getThrowable());  // this will print the result in console

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {

        }
        String filePath =  null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch ( IOException e) {

            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result){


   }
//    @Override
//    public void onTesFailedButWithinSuccessPercentage(ITestResult result){
//
//    }
//
//    @Override
//    public void onStart(ITestResult result){
//   }

//    @Override
//    public void onFinish(ITestResult result) {
//
//
//    }
}
