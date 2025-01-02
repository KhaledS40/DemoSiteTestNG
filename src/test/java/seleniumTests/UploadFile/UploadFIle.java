package seleniumTests.UploadFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UploadFIle {


    @Test
    public void clickChooseFile(){

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement seleniumTab = driver.findElement(By.xpath("//a[normalize-space()='Selenium']"));
        seleniumTab.click();
        WebElement fileUpload = driver.findElement(By.cssSelector("a[href='../../test/upload/']"));
        fileUpload.click();
        WebElement chooseFIleLink = driver.findElement(By.cssSelector("#uploadfile_0"));

        // we have to get the path for our file where it locates
        String filePath = "C:\\Users\\Khaled\\Downloads";
        // then put it as parameter inside 'sendKeys' method
        chooseFIleLink.sendKeys(filePath);
        
        WebElement termsCheckBox = driver.findElement(By.cssSelector("#terms"));
        termsCheckBox.click();
        WebElement submitButton = driver.findElement(By.cssSelector("#submitbutton"));
        submitButton.click();
        WebElement confirmText = driver.findElement(By.cssSelector("h3[id='res'] center"));
        String expected = "has been successfully uploaded.";
        String actual = confirmText.getText();
        Assert.assertEquals(actual,expected, "has been successfully uploaded.");
        driver.close();
    }
}
