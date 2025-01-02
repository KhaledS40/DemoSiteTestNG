package extentReports;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class SampleTestReport {

    WebDriver driver;
    ExtentTest test;

    @BeforeTest
    public void initializeDriver() {

        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/2013/05/page-one.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        test = ExtentReportDemo.getInstance().createTest("My first test", "Sample description");
    }

    @Test
    public void FormTest() {

        String title = driver.getTitle();
        test.info("Site Info -" + driver.getTitle());
        System.out.println(title);
        String  expected = "omayo (QAFox.com)";
        String actual = driver.getTitle();

        Assert.assertEquals(expected,actual);
    }


    @AfterTest
    public void tearDown() {

        ExtentReportDemo.getInstance().flush();
        driver.close();
    }
}

