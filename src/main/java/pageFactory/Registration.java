package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Registration {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;
    @FindBy(xpath = "//textarea[@class='form-control ng-pristine ng-untouched ng-valid']")
    WebElement textArea;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@value='Male']")
    WebElement genderSelect;

    @FindBy(id = "checkbox2")
    WebElement hobbiesCheckbox;

    //@FindBy(css = "select")
    //WebElement languageSelect;

    //@FindBy(xpath = "//section[@id='section']//li[1]")
    //WebElement languageDropdown;
    @FindBy(css = "select")
    WebElement skillsSelect;

    @FindBy(css = "select")
    WebElement selectCountry;

    @FindBy(xpath = "//*[@id=\"select2-country-container\"]")
    WebElement countryChoice;

    @FindBy(css = "select")
    WebElement dateOfBirth;

    @FindBy(css = "select")
    WebElement monthOfBirth;

    @FindBy(css = "select")
    WebElement dayOfBirth;

    @FindBy(id = "firstpassword")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='secondpassword']")
    WebElement confirmPasswordField;

    @FindBy(id = "submitbtn")
    WebElement submitButton;

    static WebDriver driver;
    public Registration (WebDriver driver){
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void goTo(){
        driver.get("https://demo.automationtesting.in/Register.html");
        System.out.println("first test to be excuted");
    }

    public void enterName(){
        firstNameField.sendKeys("Mike");

    }
    public void enterLastName(){
        lastNameField.sendKeys("Bob");

    }
    public void addText(){
        textArea.sendKeys("4600 cameron station, alexandria va");

    }
    public void enterEmail(){
        emailAddress.sendKeys("bob.mike123@gmail.com");

    }
    public void enterPhoneNumber(){
        phoneField.sendKeys("2021234567");

    }
    public void selectGender(){
        genderSelect.click();

    }
    public void selectHobbies(){
        hobbiesCheckbox.click();

    }
    //public void selectLanguage(){
        //languageSelect.click();
        //Select select = new Select(languageSelect);
        //select.selectByVisibleText(String.valueOf(languageDropdown.findElement(By.xpath("//a[normalize-space()='English']"))));

    //}
    public void selectSkills(){
        skillsSelect.click();
        Select select = new Select(skillsSelect);
        select.selectByVisibleText("Android");


    }
    public void countrySelect(){
        selectCountry.click();
        //countryChoice.click();
        Select select = new Select(selectCountry);
        select.selectByVisibleText("Denmark");

    }
    public void enterDateOfBirth(){
        dateOfBirth.click();
        Select select = new Select(dateOfBirth);
        select.selectByValue("1919");

    }
    public void selectMonth(){
        monthOfBirth.click();
        Select select = new Select(monthOfBirth);
        select.selectByVisibleText("March");

    }
    public void selectDay(){
        dayOfBirth.click();
        Select select = new Select(dayOfBirth);
        select.selectByVisibleText("3");

    }
    public void enterPassword(){
        passwordField.sendKeys("Cheers123");

    }
    public void enterConfirmedPassword(){
        confirmPasswordField.sendKeys("Cheers123");

    }
    public void clickSubmit() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        submitButton.click();
    }
    public void takeScreenShot() {
    //Thread.sleep(10);

    try{
    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(file.toPath(), new File("C:\\Users\\Khaled\\OneDrive\\Documents\\Jobs\\screenshot.jpg").toPath());
    }catch (IOException e){
    System.out.println("Exception while taking screenshot" + e.getMessage());
    }

    System.out.println("first test to be excuted");
    }

}

//English
//a[normalize-space()='English']
//section[@id='section']//li[3]

//Denmark
//1919
//March