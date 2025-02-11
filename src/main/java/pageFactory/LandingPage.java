package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LandingPage {


    @FindBy(css = "a[href='Index.html']")
    WebElement homeLink;

    @FindBy(css = "a[href='Register.html']")
    WebElement registerLink;

    @FindBy(css = "a[href='WebTable.html]")
    WebElement webTableLink;

    @FindBy(xpath = "//button[contains(text(),'alert box')]")
    WebElement alertBox;



    WebDriver driver ;
    public LandingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHomeLink() {

        homeLink.click();
        driver.navigate().back();
    }

    public void clickRegisterLink() {

        registerLink.click();
        //driver.navigate().back();
    }

    public void clickWebTableLink() {

        webTableLink.click();
        driver.navigate().back();
    }

}
