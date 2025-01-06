package pageFactory.switchToTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsSubTabPage {


    @FindBy(xpath = "//a[normalize-space()='SwitchTo']")
    WebElement switchToTab;

    @FindBy(css = "a[href='Windows.html']")
    WebElement windowsLink;

    @FindBy(xpath = "//button[contains(text(), '    click   ')]")
    WebElement clickButtonTabbedWindowTab;

    @FindBy(css = ".analystic[href='#Seperate']")
    WebElement seperateWindowsTab;

    @FindBy(css = ".analystic[href='#Multiple']")
    WebElement multipleWindowsTab;



    WebDriver driver;
    public WindowsSubTabPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickSwitchToLink() {

        switchToTab.click();
    }

    public void clickWindowsSubTab() {

        windowsLink.click();
    }

    public void clickTabbedWindowsTab() {

        System.out.println("clickTabbedWindowsTab is clicked");

        clickButtonTabbedWindowTab.click();
    }
}
