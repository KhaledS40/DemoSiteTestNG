package pageFactory.switchToTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SwitchToTabPage {

    @FindBy(xpath = "//a[normalize-space()='SwitchTo']")
    WebElement switchToTab;

    @FindBy(xpath = "//a[contains(text(), 'Alerts')]")
    WebElement alertsLink;

    @FindBy(css = ".btn.btn-danger")
    WebElement alertWithOkTab;

    @FindBy(css = ".analystic[href='#CancelTab']")
    WebElement cancelTab;

    @FindBy(css = ".btn.btn-primary")
    WebElement alertWithCancel;

    @FindBy(css = ".analystic[href='#Textbox']")
    WebElement textbox;

    @FindBy(css = ".btn.btn-info")
    WebElement alertButtonWindow;


    WebDriver driver;
    public SwitchToTabPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void clickSwitchToLink() {

        switchToTab.click();
    }

    public void clickAlertBox() {

        alertsLink.click();
    }

    public void clickAlertLink() {

        alertWithOkTab.click();
        driver.switchTo().alert().accept();
    }

    public void clickCancelTab() {

        cancelTab.click();

    }

    public void clickAlertWithOkCancelLink() {

        alertWithCancel.click();
        driver.switchTo().alert().accept();
    }

    public void clickTextbox() {

        textbox.click();
    }

    public void clickAlertButtonWindow() throws IOException {

        alertButtonWindow.click();
        driver.switchTo().alert().sendKeys("Bob");
        driver.switchTo().alert().accept();
    }
}
