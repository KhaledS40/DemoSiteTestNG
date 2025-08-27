package testCases.widgets;
import org.testng.annotations.Test;
import pageFactory.widgets.DatepickerSubTab;
import testComponents.BaseTest;
import java.util.Set;



public class Datepicker extends BaseTest {

    DatepickerSubTab datePicker;

    @Test
    public void testDatePicker(){

        datePicker = new DatepickerSubTab(driver);
        datePicker.hoverAndClickWidgetsTab();
        datePicker.clickOnCalendar();
        datePicker.clickEnabledCalendar();

        Set <String> w = driver.getWindowHandles();
    }
}
