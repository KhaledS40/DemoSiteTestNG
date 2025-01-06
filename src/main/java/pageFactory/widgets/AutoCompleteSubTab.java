package pageFactory.widgets;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AutoCompleteSubTab {

    public WebDriver driver;

    public AutoCompleteSubTab(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dropdown-toggle[href='Widgets.html']")
    WebElement widgetTab;

    @FindBy(css = "a[href='AutoComplete.html']")
    public WebElement autoComplete;

    //@FindBy(xpath = ".ui-autocomplete-multiselect.ui-state-default.ui-widget")
   // public WebElement autoCompleteFunctionalityTextBox;


    public void hoverAndClickWidgetsTab(){

        widgetTab.click();
    }

    public void clickAutoCompleteSubTab() {

        autoComplete.click();
    }

    public void enterText(String text) throws IOException {

        try {

            WebElement hiddenElement = driver.findElement(By.cssSelector(".ui-autocomplete-multiselect.ui-state-default.ui-widget"));

            // Use JavaScript to click the hidden element
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", hiddenElement);

        } finally {
            System.out.println("this is inside hidden element try catch");

        }
    }
}
