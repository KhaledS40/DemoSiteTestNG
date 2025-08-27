package testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");

        if (browserName.contains("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            if (browserName.contains("headless")){
                edgeOptions.addArguments("headless");
            }
            driver = new EdgeDriver(edgeOptions);
            driver.manage().window().setSize(new Dimension(1440, 900));

            //EdgeOptions options = new EdgeOptions();
            //options.addArguments("headless");  // enabling headless mode
            //options.addArguments("--disable-gpu");   // optional - Disable GPU for better compatibility
            //options.addArguments("--window-size=1920,1080");   // optional - Set a specific window size
            //driver = new EdgeDriver(options);



        } else if (browserName.contains("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browserName.contains("headless")){
                chromeOptions.addArguments("headless");
            }
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1440, 900));

        } else if (browserName.contains("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            if (browserName.contains("headless")){
                firefoxOptions.addArguments("headless");
            }
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().setSize(new Dimension(1440, 900));
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
