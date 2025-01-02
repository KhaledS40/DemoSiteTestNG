package seleniumTests.ScrollDownAndUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollDownUntilVisibilityOfElement {


    // To scroll down the web page by the visibility of the element.

    WebDriver driver;

    @Test
    public void ByVisibleElement() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("Linux"));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}