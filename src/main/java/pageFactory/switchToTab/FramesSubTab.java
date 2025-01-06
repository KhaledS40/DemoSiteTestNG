package pageFactory.switchToTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesSubTab {

	@FindBy(xpath = "//a[normalize-space()='SwitchTo']")
    WebElement switchToTab;
	
    @FindBy(xpath = "//a[normalize-space()='Frames']")
    WebElement framesSubTab;

    @FindBy(name= "SingleFrame")
    WebElement singleFrame;

    @FindBy(css = "input[type=\"text\"]")
    WebElement inputBoxInsideIframe;

    @FindBy(css = ".analystic[href=\"#Multiple\"]")
    WebElement multipleFrameLink;

    @FindBy(xpath = "//*[@id='Multiple']/iframe")
    WebElement nestedIframe;

    @FindBy(xpath = "/html/body/section/div/div/iframe")
    WebElement nestedIframe2;

    @FindBy(css = "input[type=\"text\"]")
    WebElement textBoxInsideNestedIframe;

    public WebDriver driver;
    public FramesSubTab(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSwitchToLink() {

        switchToTab.click();
    }
    
    public void clickOnFramesTab() {
    	
    	framesSubTab.click();
    }
    
    public void enterTextInFrameBox() {

        driver.switchTo().frame(singleFrame);
        inputBoxInsideIframe.sendKeys("Hello");
        driver.switchTo().defaultContent();
    }

    public void clickOnIframWithinIframe() {

    	multipleFrameLink.click();
    }
    
    public void enterTextInNestedFrameBox() {
    	
    	driver.switchTo().frame(nestedIframe);
    	driver.switchTo().frame(nestedIframe2);
    	textBoxInsideNestedIframe.sendKeys("Hello");
    }
}
