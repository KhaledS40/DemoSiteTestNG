package seleniumTests.ScrollDownAndUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDownPage {

    /*
        To scroll using Selenium, you can use JavaScriptExecutor interface that helps
        to execute JavaScript methods through Selenium Webdriver

        Let’s, see the scroll down a web page using the selenium webdriver with following 4 scenarios :

            Scenario 1: To scroll down the web page by pixel.
            Scenario 2: To scroll down the web page by the visibility of the element.
            Scenario 3: To scroll down the web page at the bottom of the page.
            Scenario 4: Horizontal scroll on the web page.
     */

    // To scroll down the web page at the bottom of the page.
    WebDriver driver;

    @Test
    public void ByPage() {
        WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/");

        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
