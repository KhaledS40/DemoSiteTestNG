package resources;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

import java.io.File;

public class ExtentReportsDemo {

    public static ExtentReports ExtentReportFirstTest(){

        // to generate extent report, have to remember two classes
        // one is Extent Report, other one is ExtentSparkReporter class
        // ExtentSparkReport means where the report should be created and is a helper class of Extent Report which is main class

        // to Create the report we have to get the path of the project

        String pathVariable = System.getProperty("user.dir") + "\\report\\index.html";
        //File file = new File("./Reports/testReport.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(pathVariable);

        // Using the object of ExtentSparkReporter we can use its method like setting our report name
        reporter.config().setReportName("Web Automation Results");

        // setting up DocumentTitle
        reporter.config().setDocumentTitle("Test Results");

        // Now we create our main Extent Report class that driver all report executions
        ExtentReports extent = new ExtentReports();


        // attach the extent report with the configurations and our main class has the knowledge of the object
        extent.attachReporter(reporter);


        // with this setSystem method we can set the tester name it takes a key and value
        extent.setSystemInfo("Tester", "Khaled");
        extent.createTest(pathVariable);
        return extent;
    }
}





//    @Test
//    public void initialDemo() {
//
//        // now using the object of extent report class and hit dot. and select 'createTest method it creates the test
//        extent.createTest("FirstReportTest");
//
//        // we create a report an object is created, by using that object class we can use different methods like fail etc
//        // ExtentTest is a clas that we can use its object to make the test fail, see above
//
//        //ExtentTest test = extent.createTest("FirstReportTest");
//
//        WebDriver driver = WebDriverManager.edgedriver().create();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://rahulshettyacademy.com");
//        String title = driver.getTitle();
//        System.out.println(title);
//        //test.fail("Results do not match");   // we used the object of ExtentTest clas to use the fail method and fail the test intentionally
//
//        extent.flush(); // notify the test is done

