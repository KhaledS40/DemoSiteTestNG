package testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageFactory.Registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;


    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
        prop.load(input);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();

            //EdgeOptions options = new EdgeOptions();
            //options.addArguments("headless");  // enabling headless mode
            //options.addArguments("--disable-gpu");   // optional - Disable GPU for better compatibility
            //options.addArguments("--window-size=1920,1080");   // optional - Set a specific window size
            //driver = new EdgeDriver(options);

            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }


    @BeforeMethod(alwaysRun=true)
    public void launchApplication() throws IOException {

        driver = initializeDriver();
        Registration reg = new Registration(driver);
        reg.goTo();
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){

        driver.quit();
    }
}
