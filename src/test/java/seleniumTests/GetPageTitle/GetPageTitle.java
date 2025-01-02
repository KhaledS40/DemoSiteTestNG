package seleniumTests.GetPageTitle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GetPageTitle {

    public static void main(String[] args){

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        // getting title of the page
        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
    }
}
