package seleniumTests.GetBroswerVersionName;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class CapabilitiesInterface {

    @Test
    public void getRemoteDriver() {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();


        // getting the driver version and name using Capabilities Interface

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

        // prints browser name
        System.out.println(cap.getBrowserName());

        // print browser version
        System.out.println(cap.getBrowserVersion());

        // Getting java version
        System.out.println("Java" + System.getProperty("java.version"));

        // Getting window version
        System.out.println(System.getProperty("os.name"));
    }
}