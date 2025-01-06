package testCases.widgets;

import org.testng.annotations.Test;
import pageFactory.widgets.AccordionSubTab;
import pageFactory.widgets.AutoCompleteSubTab;
import pageFactory.widgets.DatepickerSubTab;
import pageFactory.widgets.SliderSubTab;
import testComponents.BaseTest;

import java.io.IOException;

public class WidgetTab extends BaseTest {

    AccordionSubTab accord;
    AutoCompleteSubTab auto;
    DatepickerSubTab date;
    SliderSubTab slider;

    @Test(groups = {"smoke"})
    public void testDatepicker(){

        date = new DatepickerSubTab(driver);
        date.hoverAndClickWidgetsTab();
        date.clickOnCalendar();
        date.clickEnabledCalendar();

        System.out.println("this is datepicker");
    }

    @Test(groups = {"regression"})
    public void testAutoComplete() throws IOException {

        auto = new AutoCompleteSubTab(driver);
        auto.hoverAndClickWidgetsTab();
        auto.clickAutoCompleteSubTab();
        auto.enterText("hello dear");

        System.out.println("this is autocomplete");
    }

    @Test(groups = {"regression"})
    public void testAccordion(){

        accord = new AccordionSubTab(driver);
        accord.hoverAndClickWidgetsTab();
        accord.clickOnAccordion();
        accord.clickOnReadability();
        accord.clickOnSingleLineCoding();
        accord.clickOnMethodChaining();
        accord.clickOnCrossBrowserTesting();

        System.out.println("this is accordion");
    }

    @Test(groups = {"smoke"})
    public void testSlider() throws IOException {

        slider = new SliderSubTab(driver);
        slider.hoverAndClickWidgetsTab();
        slider.clickSliderSubTab();
        slider.clickSliderBar();
        slider.takeScreenShotOfBar();

        System.out.println("this is slider");
    }

}
