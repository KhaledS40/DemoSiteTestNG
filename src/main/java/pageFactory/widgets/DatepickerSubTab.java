package pageFactory.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//img[@class='imgdp']")
    WebElement datepickerImg;

    @FindBy(xpath = "//a[normalize-space()='5']")
    WebElement dateSelect;

    @FindBy(css = "#datepicker2")
    WebElement datepicker2;

    @FindBy(css = "a[title='Select Sunday, Oct 6, 2024']")
    WebElement selectDate;


    public void hoverAndClickWidgetsTab(){

        widgetTab.click();
    }

    public void hoverAndClickDatePicker(){

        datepickerSubTab.click();
    }

    public void clickOnCalendar(){

        datepickerImg.click();
        dateSelect.click();
    }

    public void clickEnabledCalendar(){

        datepicker2.click();
        selectDate.click();
    }
}
