package seleniumTests.LaunchingBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowser {

    public static void main (String[] args){

        // Launching Edge browser

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
    }
}
