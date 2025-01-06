package pageFactory.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccordionSubTab {

    public WebDriver driver;

    public AccordionSubTab(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dropdown-toggle[href='Widgets.html']")
    WebElement widgetTab;

    @FindBy(css = "a[href='Accordion.html']")
    WebElement accordionSubTab;

    @FindBy(xpath = "//b[contains(text(),'Collapsible Group 1 - Readability')]")
    WebElement readability;

    @FindBy(xpath = "//b[contains(text(),'Collapsible Group 2 - Single Line Coding')]")
    WebElement singleLineCoding;

    @FindBy(xpath = "//b[contains(text(),'Collapsible Group 3 - Methhod Chaining')]")
    WebElement methhodChaining;

    @FindBy(xpath = "//b[contains(text(),'Collapsible Group 4 - Cross Browser Testing')]")
    WebElement crossBrowserTesting;

    public void hoverAndClickWidgetsTab(){

        widgetTab.click();
    }

     public void clickOnAccordion(){

         accordionSubTab.click();
     }

     public void clickOnReadability(){

        for (int i =0; i<2; i++){
            readability.click();
        }
     }

     public void clickOnSingleLineCoding(){

         for (int i =0; i<2; i++){
             singleLineCoding.click();
         }
     }

     public void clickOnMethodChaining(){

         for (int i =0; i<2; i++){
             methhodChaining.click();
         }
     }

     public void clickOnCrossBrowserTesting(){

         for (int i =0; i<2; i++){
             crossBrowserTesting.click();
         }
     }
}
