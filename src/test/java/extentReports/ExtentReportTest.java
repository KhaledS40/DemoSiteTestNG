package extentReports;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Watchable;
import java.time.Duration;
import java.util.HashMap;

public class ExtentReportTest {

    public WebDriver driver;
    ExtentTest test;

    @BeforeTest
    public void browserSetUp(){

        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        test = ExtentReportDemo.getInstance().createTest("My test", " description");
    }

    @Test
    public void testForm(){

        HashMap<String, By> locators = new HashMap<String, By>();
        locators.put("FirstName", By.cssSelector("input[placeholder='First Name']"));
        locators.put("Lastname", By.cssSelector("input[placeholder='Last Name']"));
        locators.put("Address", By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid[rows='3']"));
        locators.put("emailAddress", By.cssSelector("input[type='email']"));

        WebElement username= driver.findElement(locators.get("FirstName"));
        WebElement lastname = driver.findElement(locators.get("Lastname"));
        WebElement address = driver.findElement(locators.get("Address"));
        WebElement email = driver.findElement(locators.get("emailAddress"));

        username.sendKeys("Bob");
        lastname.sendKeys("Mikey");
        address.sendKeys("4600 Duke street");
        email.sendKeys("bob.mieky@gmail.com");
    }

    @AfterTest
    public void tearDown(){

        driver.close();
    }
}
