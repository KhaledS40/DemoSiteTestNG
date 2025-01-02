package seleniumTests.ScrollDownAndUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class HorizontalScrollingPage {


    // Horizontal scroll on the web page

    WebDriver driver;
    @Test
    public void ScrollHorizontally() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");

        WebElement Element = driver.findElement(By.linkText("VBScript"));
        //WebElement scroll = driver.findElement(By.cssSelector("#rt-feature"));

        //This will scroll the page Horizontally till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

        driver.close();
    }
}
