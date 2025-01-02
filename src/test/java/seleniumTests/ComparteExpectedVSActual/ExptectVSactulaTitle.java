package seleniumTests.ComparteExpectedVSActual;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class ExptectVSactulaTitle {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        // getting title of the page
        String title = driver.getTitle();
        System.out.println(title);
        String  expected = "omayo (QAFox.com)";
        String actual = driver.getTitle();

    // comparing actual title to expected title
//        if (actual.equals(expected)){
//            System.out.println("test is passed");
//        } else {
//            System.out.println("TEST IS FAILED");
//        }

        // Using assertion
        Assert.assertEquals(actual,expected);

        driver.close();

    }
}