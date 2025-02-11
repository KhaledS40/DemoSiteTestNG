package pageFactory.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DatepickerSubTab {

    public WebDriver driver;

    public DatepickerSubTab(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dropdown-toggle[href='Widgets.html']")
    WebElement widgetTab;

    @FindBy(xpath = "//a[normalize-space()='Datepicker']")
    WebElement datepickerSubTab;

    @FindBy(linkText = "Datepicker")
    WebElement datepickerImg;

    @FindBy(css = ".ui-state-default")  // 20
    List<WebElement> dateSelect;

    @FindBy(css = "#datepicker2")
    WebElement datepicker2;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[4]/td[4]")
    WebElement selectDate;


    public void hoverAndClickWidgetsTab(){

        widgetTab.click();
    }

    public void hoverAndClickDatePicker(){

        datepickerSubTab.click();
    }

    public void clickOnCalendar() {

        datepickerImg.click();
        for (WebElement date : dateSelect) {
            if (date.getText().equals(20)) {
                date.click();
                break;
            }
        }
    }
    public void clickEnabledCalendar(){

        datepicker2.click();
        selectDate.click();
    }
}
